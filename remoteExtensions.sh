#!/bin/bash
CUSTOM_DIRECTORY_PATH="/Users/aleksandra/Desktop/epam/Hybris/hybris-mentoring"
CUSTOM_CONFIG="$CUSTOM_DIRECTORY_PATH/config/dev"
CUSTOM_EXTENSIONS="$CUSTOM_DIRECTORY_PATH/extensions"

HYBRIS_DIR_PATH="/Users/aleksandra/Desktop/epam/Hybris"
HYBRIS_CONFIG_PATH="$HYBRIS_DIR_PATH/hybris/config"
HYBRIS_EXTENSIONS_PATH="$HYBRIS_DIR_PATH/hybris/bin/custom"

ln -f "$HYBRIS_CONFIG_PATH/localextensions.xml" "$CUSTOM_CONFIG/localextensions.xml"
ln -f "$HYBRIS_CONFIG_PATH/local.properties" "$CUSTOM_CONFIG/local.properties"

rm -rf "$HYBRIS_EXTENSIONS_PATH"
ln -s "$CUSTOM_EXTENSIONS" "$HYBRIS_EXTENSIONS_PATH" 