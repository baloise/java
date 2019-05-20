# Java Working Group 

## Mission Statement

> The goal of the Java Developer Community is to exchange, share, and standardize knowhow about Java, JavaEE, and other emerging Java technologies. We provide recommendation for solutions with proof of concept. We help each other in a community-driven manner. We promote upgrading the Java environment used within the Basler to the newest version  

### Minor Topics

* ApplicationServer / Fuse runtime environment

### Out of Scope

* Other JVM languages (Gosu, Scala, ...)
* Development tools (Jenkins et al.)

## Project Structure

Is not finalized, initiate it by putting your first contribution here and updating this README.
# repository-template-java
A template to use when starting a new project.

## perform a repository wide search and replace for "repository-template-java" and the "target-repo-name"

e.g. by using

```
cp -R repository-template-java/ new-name && cd new-name && git config --local --unset remote.origin.url && git config --local --add remote.origin.url git@github.com:baloise/new-name.git && git reset --hard $(git commit-tree FETCH_HEAD^{tree} -m "Initial contribution") &&  git grep -l 'repository-template-java' | xargs sed -i '' -e 's/repository-template-java/new-name/g' && mvn clean verify && git add -A && git commit -m "Rename from template to new-name" && cd ..
```

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/bf6fa237dd934970991ecba2c66db23e)](https://app.codacy.com/app/baloise/repository-template-java?utm_source=github.com&utm_medium=referral&utm_content=baloise/repository-template-java&utm_campaign=Badge_Grade_Dashboard)
[![DepShield Badge](https://depshield.sonatype.org/badges/baloise/repository-template-java/depshield.svg)](https://depshield.github.io)
[![Build Status](https://travis-ci.org/baloise/repository-template-java.svg?branch=master)](https://travis-ci.org/baloise/repository-template-java)
[![Codecov](https://img.shields.io/codecov/c/github/baloise/repository-template-java.svg)](https://codecov.io/gh/baloise/repository-template-java)
[![gitpod-IDE](https://img.shields.io/badge/open--IDE-as--gitpod-blue.svg?style=flat&label=openIDE)](https://gitpod.io#https://github.com/baloise/repository-template-java)

## the [docs](docs/index.md)
