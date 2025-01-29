#!/bin/bash

# Extraer el porcentaje de cobertura del archivo jacoco.xml
COVERAGE=$(grep -oP '(?<=<counter type="LINE" missed=")[^"]*' target/site/jacoco/jacoco.xml)
TOTAL=$(grep -oP '(?<=<counter type="LINE" covered=")[^"]*' target/site/jacoco/jacoco.xml)

# Calcular el porcentaje de cobertura
if [ -z "$COVERAGE" ] || [ -z "$TOTAL" ]; then
  echo "No se pudo extraer la cobertura."
  exit 1
fi

PERCENTAGE=$(echo "scale=2; 100 * $TOTAL / ($TOTAL + $COVERAGE)" | bc)
echo "Cobertura: $PERCENTAGE%"

# Guardar el porcentaje en un archivo para usarlo en el badge
echo $PERCENTAGE > coverage.txt