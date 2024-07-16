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
- Inside resources type arm-storage and hit "enter"
- It will create below contents in "resources"

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
### Change "name", "displayName", "sku" and tags as per need and save the file

### After configuring resources
```
{
    "$schema": "https://schema.management.azure.com/schemas/2019-04-01/deploymentTemplate.json#",
    "contentVersion": "1.0.0.0",
    "parameters": {},
    "functions": [],
    "variables": {},
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
    "outputs": {}
}
```
### Run following command from Azure cli to create a storage account
```
az deployment group create --name <deployment-name> --resource-group <resource-group-name> --template-file my-template.json

```

### Add Parameters
- Inside parameters, type "new" and hit "enter"
- It will give below and add and configure parameters according to need
  ```
      "parameters": {"parameter1": {
        "type": "string",
        "metadata": {
            "description": "description"
        }
    }},

  ```

  - I will create parameters for sku "tier" and and update as below.
  

  ```
  {
    "$schema": "https://schema.management.azure.com/schemas/2019-04-01/deploymentTemplate.json#",
    "contentVersion": "1.0.0.0",
    "parameters": {"skutier": {
        "type": "string",
        "metadata": {
            "description": "parameter for sku name"
        },
        "defaultValue":"Premium_LRS",
        "allowedValues":["Premium", "Standard"]
    }},
    "functions": [],
    "variables": {},
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
            "tier": "[parameters('skutier')]"
        }
    }],
    "outputs": {}
}
  ```

