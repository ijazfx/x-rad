rem if NOT EXISTS ..\Development Package Ready\nstudio
md "..\Development Package Ready\nstudio"
rem if not exists ..\Development Package Ready\nstudio\CodeGeneration
md "..\Development Package Ready\nstudio\CodeGeneration"
rem if not exists ..\Development Package Ready\nstudio\CodeGeneration\codegen
md "..\Development Package Ready\nstudio\CodeGeneration\codegen"
copy x-rad-studio-1.0-win.exe "..\Development Package Ready\nstudio\nstudio.exe"
copy x-rad-studio-1.0.jar "..\Development Package Ready\nstudio\nstudio.jar"
copy x-rad-cg.properties "..\Development Package Ready\nstudio"
copy x-rad-laf.properties "..\Development Package Ready\nstudio"
md "..\Development Package Ready\nstudio\CodeGeneration"
echo completed
xcopy .\CodeGeneration\codegen  "..\Development Package Ready\nstudio\CodeGeneration\codegen" /R /H /E /Y
copy .\readme.txt "..\Development Package Ready\nstudio\readme.txt"
