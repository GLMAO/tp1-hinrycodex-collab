# Compiler et exécuter le projet TP1
Write-Host "Compilation en cours..."
$files = Get-ChildItem -Recurse -Filter *.java | Where-Object { $_.FullName -notmatch "\\test\\" } | ForEach-Object { $_.FullName }
javac -d bin -cp . $files

Write-Host "Exécution..."
java -cp bin org.emp.gl.core.launcher.App