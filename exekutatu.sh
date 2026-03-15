#!/bin/bash

# 1. Definición de rutas según tu estructura
PAQUETES="src/modelo src/vista"
AUTORES=("Jon878-max" "ComradeTxuria" "JonMaguna" "JonZalbide")

declare -A conteo
total_lineas=0

echo "Analizando el núcleo de Space_Invaders (modelo y vista)..."

# Buscamos archivos .java en las carpetas indicadas
for archivo in $(find $PAQUETES -name "*.java" 2>/dev/null); do
    # Procesamos cada línea del archivo con git blame
    while read autor; do
        for oficial in "${AUTORES[@]}"; do
            if [[ "$autor" == "$oficial" ]]; then
                ((conteo["$autor"]++))
                ((total_lineas++))
            fi
        done
    done < <(git blame --line-porcelain "$archivo" | sed -n 's/^author //p')
done

# --- RESULTADOS FINALES ---
echo -e "\n===================================================="
echo -e "   ESTADÍSTICAS DE APORTACIÓN: SPACE INVADERS"
echo -e "===================================================="
printf "%-18s | %-10s | %-10s\n" "AUTOR" "LÍNEAS" "PORCENTAJE"
echo "----------------------------------------------------"

# Imprimir resultados con cálculo de porcentaje
if [ $total_lineas -gt 0 ]; then
    for autor in "${AUTORES[@]}"; do
        lineas=${conteo["$autor"]:-0}
        # Cálculo simple de porcentaje (usando bc para decimales si está disponible, o entero)
        porcentaje=$(( 100 * $lineas / $total_lineas ))
        printf "%-18s | %-10s | %-10d%%\n" "$autor" "$lineas" "$porcentaje"
    done
else
    echo "No se detectaron líneas de código en las rutas especificadas."
fi
echo "===================================================="
echo "Total de líneas analizadas: $total_lineas"
