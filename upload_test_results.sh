#!/bin/bash

# Check if we should upload to Allure TestOps based on the build ID
if bash -c '[[ "$CODEBUILD_BUILD_ID" = "cusbo-ci-pipeline-stuff-build-api:"* ]]'; then
  export ALLURE_UPLOAD="true"
fi

# Upload to Allure TestOps if the flag is set
if [ "$ALLURE_UPLOAD" = "true" ]; then
  echo "Uploading test reports to Allure TestOps"
  ./allurectl upload --launch-name "New commit" ./api/target/allure-results
fi
