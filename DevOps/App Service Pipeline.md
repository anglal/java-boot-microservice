## Azure pipeline and infrastructure for dot net appliction for App Service Deployment ##

## Repo ##
1. GitHub/ Azure DevOps Git
2. Cloud Microsoft Azure

## Create a build pipeline ##
- Use GitHub as repository and select appropriate respository and authetnicate
- When creating pipeline, it will create a sevice connection to connect to GitHub
- In pipeline, select ASP.NET core(.NET Framework)
- It will generate the build task as below
```
# ASP.NET Core (.NET Framework)
# Build and test ASP.NET Core projects targeting the full .NET Framework.
# Add steps that publish symbols, save build artifacts, and more:
# https://docs.microsoft.com/azure/devops/pipelines/languages/dotnet-core

trigger:
- main

pool:
  vmImage: 'windows-latest'

variables:
  solution: '**/*.sln'
  buildPlatform: 'Any CPU'
  buildConfiguration: 'Release'

steps:
- task: NuGetToolInstaller@1

- task: NuGetCommand@2
  inputs:
    restoreSolution: '$(solution)'

- task: VSBuild@1
  inputs:
    solution: '$(solution)'
    msbuildArgs: '/p:DeployOnBuild=true /p:WebPublishMethod=Package /p:PackageAsSingleFile=true /p:SkipInvalidConfigurations=true /p:DesktopBuildPackageLocation="$(build.artifactStagingDirectory)\WebApp.zip" /p:DeployIisAppPath="Default Web Site"'
    platform: '$(buildPlatform)'
    configuration: '$(buildConfiguration)'

- task: VSTest@2
  inputs:
    platform: '$(buildPlatform)'
    configuration: '$(buildConfiguration)'

```
- To publish the artifact to App service put the cursor at the and of the pipeline and click on show assistant and searh for "Publish build artifacts"
- It will create below task:
```
- task: PublishBuildArtifacts@1
  inputs:
    PathtoPublish: '$(Build.ArtifactStagingDirectory)'
    ArtifactName: 'drop'
    publishLocation: 'Container'
```

##  Create a manual Release pipeline ##

## Pre requisites ##
- Service Principal(Create manually if the user in devOps does not have subscription to Azure resources), otherwise it will be created automatically by azure devops just using the subscription
  
- Service Connection to Azure Resources
- App Service

## Create Service Principal manually ##
- Use this approach if the user in DevOps does not have subscription to Azure Resources
- Login to Azure portal
- Search for "App registrations"
- "+ New registration"
- Name: Name of the service principal
- Supported account types: Multitenant if it needs to be accessed from different tenant, eg. the user in Azure DevOps does not have subscription to Azure resources, if the user does, use Single tenant)
- Redirect URI is optional
- Register

## Create Service Principal key (AKA secret) ##
- Go to recently created service principal/application
- In "Client credentials", "Add a certificate or secret"
- "New client secret"
- Add Description
- Add

## Create Service Connection to Azure Resources ##
- Go to organization, then go to project
- Go to "project settings" left bottom corner
- Under Pipelines, go to service connections
- New service connection
- Choose Azure Resource Manager as service connection type
- Authentication Method, select "Service principal(manual)" if the user does not have subscription to Azure Resources, automatic if the user has subscrition
- Environment : Azure Cloud
- Subscription id: subscription id of azure resource where app service and other resources are residing
- Subscription name: subscription name of the azure resource where app service and other resources are residing
- Service Principal Id : Go to app registration and find the service principal/applications and use Application(client) ID.
- Service Principal key: Got to recently created Service Principal/Application and copy the secret
- Tenant id: Copy from recently created Service Principal
- Verify: Sometimes it does not verify, that's okay as long as all the values are supplied as given above
- Service connection name: Give a name
- Grant access to all pipelines if this service connection is intended to be used by all pipelines
- Save without verification if it does not verify

## Create an app service ##
- In the Azure Portal, search "App Services" and create Web App
- Publish: code
- Runtime Stack: .NET 6 (LTS)
- OS: Windows
- Rest fill according to need

## Create a release pipeline ##
- Go to releases
- New pipeline
- On the right corner, template, select "Azure App Service deployment"
- Name the stage
- Configure artifact by clicking "Add an artifact"
- Seclet source type as "Build" as build pipeline contains the artifact
- Select corresponding project andd source
- Add
- To activate continuous deployment right after build, click on lightening symbol and enable
- Azure subscription: select the service connection
- Add deployment job and task by clicking "1 job, 1 task"
- App type: Web App on Windows
- 
