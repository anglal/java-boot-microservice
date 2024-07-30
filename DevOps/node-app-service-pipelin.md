### This build pipeline is for ADO pipeline
### It just copies files and produces an artifact to be deployed by release pipeline

```
trigger:
  - main
pool:
  vmImage: windows-latest
steps:
  - task: CopyFiles@2
    inputs:
      Contents: '**/*'
      TargetFolder: '$(Build.ArtifactStagingDirectory)'
  - task: PublishBuildArtifacts@1
    inputs:
      PathtoPublish: '$(Build.ArtifactStagingDirectory)'
      artifactName: 'drop'
      publishLocattion: 'Container'

```
