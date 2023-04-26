#!/bin/bash

# Check if we should upload to Allure TestOps based on the build ID
if bash -c '[[ "$CODEBUILD_BUILD_ID" = "cusbo-build-project:"* ]]'; then
  ./allurectl upload --launch-name "New commit" ./api/target/allure-results
fi
