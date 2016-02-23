# To test the ci release locally use the following command:
# sh -x ci-release.sh

CI_BUILD_DIR=$(pwd)
cd .ci-build/whole/org.whole.products.releng
gradle --quiet release
cd $CI_BUILD_DIR

