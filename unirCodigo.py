import os

# Ruta al directorio donde está tu proyecto
directorio = "/Users/isaizurita/plataformaAdopciones"
archivo_salida = "proyecto_completo.txt"  # mejor usar .txt para mezclar tipos

with open(archivo_salida, "w", encoding="utf-8") as salida:
    for subdir, dirs, files in os.walk(directorio):
        for file in files:
            if file.endswith((".java", ".css", ".fxml")):
                ruta = os.path.join(subdir, file)
                
                salida.write(f"// ===== Archivo: {ruta} =====\n")
                
                with open(ruta, "r", encoding="utf-8") as f:
                    salida.write(f.read() + "\n\n")