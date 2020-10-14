# bell project

# Overview
Bell is a command line **note** management tool.

It is a demonstration of following technologies:
- Quarkus (both client and server side)
- Knative (serverless)
- Tekton pipelines

# Technology overview
This project uses Quarkus, the Supersonic Subatomic Java Framework. It uses also postgres database to store notes. 

The client side is built using Quarkus and communicates with REST server component using rest client library. 
The REST server component is build with Quarkus with standard library and interacts with DB layer (postgres) using **hibernate-panache** library. This component is deployed via Knative serving component into **OpenShift** and consumed through this technology.

The **OpenShift Pipelines** (Tekton) is used to build and deploy the applycation on demand in **native** mode.


## Contribution is welcome