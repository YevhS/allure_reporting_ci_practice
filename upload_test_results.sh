#!/bin/bash

# Check if we should upload to Allure TestOps based on the build ID
if [[ "$CODEBUILD_BUILD_ID" = "cusbo-build-project:"* && -d "./target/allure-results" ]]; then
  ./allurectl upload --launch-name "New commit" ./target/allure-results
fi
