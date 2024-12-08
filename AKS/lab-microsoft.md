**Lab 1**
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
8. Define Global Variables using **PowerShell**
   $INITIALS="$($YOUR_INITIALS)".ToLower()
   $RESOURCE_GROUP="azure-$($INITIALS)-rg"
   $LOCATION="westus2"
9. Get list of available VM sizes with 2 cores in your region.
   az vm list-sizes --location $LOCATION --query "[?numberOfCores == ``2``].{Name:name}" -o table
10. Set the VM SKU to one of the available values or use the default below.
    $VM_SKU="Standard_DS2_v2"
11. Create resource group and a basic cluster using Azure CLI
    az group create --location $LOCATION `
                --resource-group $RESOURCE_GROUP
12. Define variables for AKS cluster.
    $AKS_NAME="aks-$($INITIALS)"
Write-Host "AKS Cluster Name: $AKS_NAME"
13. Create a simple AKS cluster.
    az aks create --node-count 2 --generate-ssh-keys --node-vm-size $VM_SKU --name $AKS_NAME   --resource-group $RESOURCE_GROUP

14. Once complete, connect the cluster to your local client machine.
    az aks get-credentials --name $AKS_NAME --resource-group $RESOURCE_GROUP
    or
    az aks get-credentials --name $AKS_NAME --resource-group $RESOURCE_GROUP --overwrite-existing
15. Confirm connection
    kubectl get nodes

**Lab 2**
Create a Pod Declaratively
manifest file:
```
apiVersion: v1
kind: Pod
metadata:
  name: nginx-pod1
  labels:
    app: nginx
spec:
  nodeSelector:
    kubernetes.io/os: linux  # Ensure the pod is scheduled on Linux nodes
  containers:
  - name: nginx
    image: nginx:latest
    ports:
    - containerPort: 80
      protocol: TCP  # Specify TCP protocol for port 80
```

Command: 1. Create pod -> kubectl apply -f my-pod.yaml
         2. Delete pod -> kubectl delete pod nginx-pod1
16. Get pods
    kubectl get pods
17. Below is the pod manifest file with two containers
    ```
    apiVersion: v1
kind: Pod
metadata:
  name: nginx-mysql-pod
  labels:
    app: nginx-mysql
spec:
  nodeSelector:
    kubernetes.io/os: linux  # Ensure the pod runs only on Linux nodes
  containers:
  - name: nginx
    image: nginx:latest
    ports:
    - containerPort: 80
  - name: mysql
    image: mysql:5.7
    env:
    - name: MYSQL_ROOT_PASSWORD
      value: "rootpassword"
    ports:
    - containerPort: 3306
    ```
18. Deploy above pod (kubectl apply -f simple-pod2-langde.yaml)
19. Show all labels
    kubectl get pods --show-labels
20. Filter pods based on label (-l)
    kubectl get pod -l kind=web

22. Query complete definition of a Pod from its internal database by exporting the output (-o) to YAML. Then pipe the result to a file.
    kubectl get pods nginx-pod -o yaml > mypod.yaml
23. For json
    kubectl get pods nginx-pod -o yaml > mypod.json
25. Open the yaml on VS Code
    code mypod.yaml
26. Update labels of running pod
    kubectl label pod nginx-pod health=fair
27. Show the labels of a pod
    kubectl get pods nginx-pod --show-labels
29. Update an existing label that is assigned to a running pod
    Change the value of the label kind=web to kind=db of the nginx-pod pod.
    kubectl label pod nginx-pod kind=db --overwrite
30. Delete a label that is assigned to a running Pod -> NOTE: Notice the minus (-)
    kubectl label pod nginx-pod health-    
32. Remove a label from all running pods by using the --all flag.
33. Delete Pods based on their labels
    kubectl delete pod -l target=dev
34. Deployments
    deployment.yaml
    ```
        apiVersion: apps/v1
        kind: Deployment
        metadata:
          name: nginx-deployment
          labels:
            app: nginx
        spec:
          replicas: 1  # Number of replicas (pods) to run
          selector:
            matchLabels:
              app: nginx
          template:
            metadata:
              name: nginx-pod  # Name of the pod
              labels:
                app: nginx
            spec:
              nodeSelector:
                kubernetes.io/os: linux  # Ensure the pod runs on Linux nodes
              containers:
              - name: nginx
                image: nginx:latest
                ports:
                - containerPort: 80
                  protocol: TCP  # Specify TCP protocol for port 80
    ```
    service.yaml
    ```
            apiVersion: v1
            kind: Service
            metadata:
              name: nginx-service
            spec:
              selector:
                app: nginx  # This selector matches the Pods created by the Deployment
              ports:
                - protocol: TCP
                  port: 80       # The port that the Service will expose
                  targetPort: 80 # The port on the container (Nginx) that the Service forwards to
              type: LoadBalancer  # Expose the service externally using a LoadBalancer
    ```
    
35. Create a Deployment and a Service to access the Pods of the deployment.
    kubectl apply -f deployment.yaml
    kubectl apply -f service.yaml
37. This command applies your manifest file and records the command in the resource annotations.
    kubectl apply -f <file>.yaml --record
38. Show the Pods, ReplicaSets, Deployments and Services
    kubectl get all --show-labels
39. Get services
    kubectl get svc
40. Open browser and browse the external ip to access the service
41. Update image version using command:
    ```
    kubectl set image deployment nginx-deployment nginx=nginx:1.27.3

    ```
    deployment name -> nginx-deployment
    Updated image name -> nginx:2.0
    Name of the container -> nginx
    
    ![image](https://github.com/user-attachments/assets/40c41759-2074-4d8e-b140-61b0f6745832)

    This image will change to nginx:1.27.3
42. Describe deployment
    kubectl describe deployment nginx-deployment
43. Show everything
    kubectl get all

    Notice that the old replica set still exists, even though it has 0 Desired Pods.
    ![image](https://github.com/user-attachments/assets/9d7540d7-0491-47f3-92d6-13025a430790)
44. Describe command on that old ReplicaSet.
    ```
    kubectl describe rs nginx-deployment-55897d69df
    ```

45. The old definition still has the previous version number. This is maintained so you can roll back the change to that version.
** Rollback the Deployment**
**The purpose of maintaining the previous ReplicaSet is to be able to rollback changes to any previous version.**
47. Deployment history.
    kubectl rollout history deploy/nginx-deployment
48. Rollback the Deployment to the previous version.
    kubectl rollout undo deploy/nginx-deployment
49. Delete the Deployment and Service
    ```
    kubectl delete deployment nginx-deployment
    kubectl delete service nginx-service
    ```
50. **Services**: Services help you expose Pods externally using label selectors.
51. Service manifest file
    ```
    ```
53. kubectl apply -f sample-dep.yaml




















    
