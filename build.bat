@echo off

set MY_MACROS =-DCUDA_ENABLED=false /Wall
set CL_PATH="C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.35.32215/bin/Hostx64/x64/cl.exe"
set INCLUDE_MSVC=/I "C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.35.32215/include"
set INCLUDE_WKITS=/I "C:/Program Files (x86)/Windows Kits/10/Include/10.0.22000.0/ucrt"
set INCLUDE_DIRS=%INCLUDE_MSVC% %INCLUDE_WKITS%
set OUTPUT=/Fe: ./bin/brainy.exe
set SRC=main.cpp
set LIBS=/LIBPATH:"C:/Program Files/Microsoft Visual Studio/2022/Community/VC/Tools/MSVC/14.35.32215/lib/x64" /LIBPATH:"C:/Program Files (x86)/Windows Kits/10/Lib/10.0.22000.0/ucrt/x64" /LIBPATH:"C:/Program Files (x86)/Windows Kits/10/Lib/10.0.22000.0/um/x64"
%CL_PATH% %MY_MACROS% %INCLUDE_DIRS% /EHsc /nologo %OUTPUT% %SRC% /link %LIBS% /MACHINE:X64