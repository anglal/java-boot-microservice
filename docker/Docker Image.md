### Create Docker Image using Azure Cloud Shell
- Upload all the files and Docker file
- Run below command from Azure Cloud Shell
  ```
    az acr build --image sample/hello-world:v1 --registry mycontainerregistry008 --file Dockerfile .
  ```
### Link to Microsoft doc: https://learn.microsoft.com/en-us/azure/container-registry/container-registry-quickstart-task-cli
