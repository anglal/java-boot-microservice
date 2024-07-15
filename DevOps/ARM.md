## Azure Resource Manager(ARM) Templates

### Prerequisites
- Visual Studio Code
- Go to Extensions, add Azure Resource Manager(ARM) tool

### Login to Azure in Windows Command Line or GitBash etc.
```
az login
```
### Create Resource Group using below command

```
az group create -l westus -n MyResourceGroup
```
### Create ARM Template(in json)
```
arm!
```
### It will create below code
```
{
    "$schema": "https://schema.management.azure.com/schemas/2019-04-01/deploymentTemplate.json#",
    "contentVersion": "1.0.0.0",
    "parameters": {},
    "functions": [],
    "variables": {},
    "resources": [],
    "outputs": {}
}

```

### Edit resources
-Inside resources type arm-storage and hit "enter"
-It will create below contents in "resources"

```
"resources": [{
        "name": "storageaccount1",
        "type": "Microsoft.Storage/storageAccounts",
        "apiVersion": "2023-01-01",
        "tags": {
            "displayName": "storageaccount1"
        },
        "location": "[resourceGroup().location]",
        "kind": "StorageV2",
        "sku": {
            "name": "Premium_LRS",
            "tier": "Premium"
        }
    }],
```
