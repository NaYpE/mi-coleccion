#!/bin/bash

# Ruta al archivo jacoco.xml
JACOCO_FILE="target/site/jacoco/jacoco.xml"

# Verificar que el archivo existe
if [ ! -f "$JACOCO_FILE" ]; then
  echo "❌ Error: El archivo jacoco.xml no existe en $JACOCO_FILE."
  echo "Asegúrate de ejecutar 'mvn test jacoco:report' para generar el informe de cobertura."
  exit 1
fi

# Extraer los valores de missed y covered
MISSED=$(grep -o '<counter type="LINE" missed="[0-9]*" covered="[0-9]*"/>' "$JACOCO_FILE" | awk -F'"' '{missed+=$4} END {print missed}')
COVERED=$(grep -o '<counter type="LINE" missed="[0-9]*" covered="[0-9]*"/>' "$JACOCO_FILE" | awk -F'"' '{covered+=$8} END {print covered}')

# Verificar que se extrajeron los valores
if [ -z "$MISSED" ] || [ -z "$COVERED" ]; then
  echo "❌ Error: No se pudo extraer la cobertura del archivo jacoco.xml."
  echo "Asegúrate de que el archivo tenga el formato correcto."
  exit 1
fi

# Calcular el total de líneas
TOTAL=$((MISSED + COVERED))

# Evitar división por 0
if [[ "$TOTAL" -eq 0 ]]; then
  echo "❌ Error: No hay líneas totales para calcular cobertura."
  exit 1
fi

# Calcular el porcentaje usando awk
PERCENTAGE=$(awk "BEGIN { printf \"%.2f\", (100 * $COVERED / $TOTAL) }")

# Mostrar resultados
echo "MISSED=$MISSED"
echo "COVERED=$COVERED"
echo "TOTAL=$TOTAL"
echo "✅ Cobertura Total: $PERCENTAGE%"