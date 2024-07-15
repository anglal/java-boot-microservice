## Azure-CLI
- Less Errors
- Quick
- Automation

### Check version
```
az vesrion
```

### Login to Azure 
```
az login
```

### Set the correct subscription
```
az account set --subscription <subscription_id_or_name>
```

### Show the Azure Account
```
az account show
```

### List resource groups
```
az group list --output table
```

### List all front doors
```
az network front-door list --resource-group myresourcegroup --output table
```

