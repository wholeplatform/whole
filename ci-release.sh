# To test the ci release locally use the following command:
# sh -x ci-release.sh

pushd .ci-build/whole/org.whole.products.releng
gradle --quiet release
popd

