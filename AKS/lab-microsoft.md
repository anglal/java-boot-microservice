Lab1
1. Exercise: Create a Basic Azure Kubernetes Service (AKS) Cluster

1. Login into your subscription and register providers
2. Login to Azure using cloudshell on Azure Portal or command prompt on Windows or Terminal (mac) usin Azure CLI(You might have to clear cache sometimes before log in by runing - "az account clear")
    az login
3. Set the subscription
   az account set --subscription "<subscription-name>"
4. Register needed providers(run on command prompt)
    az provider register --namespace Microsoft.Storage
    az provider register --namespace Microsoft.Compute
    az provider register --namespace Microsoft.Network
    az provider register --namespace Microsoft.Monitor
    az provider register --namespace Microsoft.Insights
    az provider register --namespace Microsoft.ManagedIdentity
    az provider register --namespace Microsoft.OperationalInsights
    az provider register --namespace Microsoft.OperationsManagement
    az provider register --namespace Microsoft.KeyVault
    az provider register --namespace Microsoft.ContainerRegistry
    az provider register --namespace Microsoft.ContainerService
    az provider register --namespace Microsoft.Kubernetes
5. Check if providers are registered by
    Open a browser and navigate to the Azure Portal: portal.azure.com
    Search for and open the Subscriptions blade. Select your subscription.
    Scroll down and select Resource providers.
6. Task 2 - Define variables and create resource group using **PowerShell**
   $YOUR_INITIALS="<your initials>"
8. 
   
