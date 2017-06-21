@echo off

SET CUSTOM_DIRECTORY_PATH="C:\Hybris_training"
SET CUSTOM_CONFIG=%CUSTOM_DIRECTORY_PATH%\config\dev
SET CUSTOM_EXTENSIONS=%CUSTOM_DIRECTORY_PATH%\extensions

SET HYBRIS_DIR_PATH="C:\Hybris_folder"
SET HYBRIS_CONFIG_PATH=%HYBRIS_DIR_PATH%\hybris\config
SET HYBRIS_EXTENSIONS_PATH=%HYBRIS_DIR_PATH%\hybris\bin\custom

if exist "%HYBRIS_CONFIG_PATH%\localextensions.xml" (
	del /F %HYBRIS_CONFIG_PATH%\localextensions.xml
) else (
	echo localextensions.xml DOES NOT EXIST
)

if exist "%HYBRIS_CONFIG_PATH%\local.properties" (
	del /F %HYBRIS_CONFIG_PATH%\local.properties
) else (
	echo local.properties DOES NOT EXIST
)

MKLINK /H "%HYBRIS_CONFIG_PATH%\localextensions.xml" "%CUSTOM_CONFIG%\localextensions.xml"
MKLINK /H "%HYBRIS_CONFIG_PATH%\local.properties" "%CUSTOM_CONFIG%\local.properties"

if exist "%HYBRIS_EXTENSIONS_PATH%" RMDIR /Q /S "%HYBRIS_EXTENSIONS_PATH%"
MKLINK /J "%HYBRIS_EXTENSIONS_PATH%" "%CUSTOM_EXTENSIONS%"

pause
:exit