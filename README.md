# bell project

# Overview
Bell is a command line *note* management tool.



# Technology behind
This project uses Quarkus, the Supersonic Subatomic Java Framework. It uses also postgres database to store notes




If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `bell-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/bell-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/bell-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.


## Execute
java -jar ./target/bell-1.0.0-SNAPSHOT-runner.jar note create -n "the first note" -l "lbl1,lbl2,lbl3"

java -jar ./target/bell-1.0.0-SNAPSHOT-runner.jar note create -n "the second note" -l "lbl1,lbl2,lbl4"



## GET the kourier endpoint
export SVC_URL=`kubectl get rt greeter -o yaml | yq read - 'status.url'` && \
http $SVC_URL