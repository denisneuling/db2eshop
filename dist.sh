#!/bin/bash
mkdir -p dist
if [ ! -f target/db2eshop-0.0.1-SNAPSHOT-executable.jar ]; then
    ./build.sh
fi
cp target/db2eshop-0.0.1-SNAPSHOT-executable.jar dist/
