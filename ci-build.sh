# To test the ci build locally use the following command:
# sh -x ci-build.sh

mkdir -p .ci-build/whole
cp -a * .git .gitignore .ci-build/whole/
CI_BUILD_DIR=$(pwd)
cd .ci-build
git clone https://github.com/wholeplatform/whole-java-libs.git
git clone https://github.com/wholeplatform/whole-examples.git
git clone https://github.com/wholeplatform/whole-platform-products.git
cd whole/org.whole.products.releng
export M2_HOME=$(mvn -v | grep "^Maven home:" | sed "s/^[^\/]*//")
echo -e "Configuring Maven with:\nMAVEN_OPTS=$MAVEN_OPTS\nM2_HOME=$M2_HOME"
gradle --quiet integration_test build
cd $CI_BUILD_DIR

