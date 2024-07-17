## Vnets
### Vnet Address Spaces
- TestVnet - 192.168.0.0/16
- FrontEnd Subnet - 192.168.1.0/24
- BackEnd Subnet- 192.168.2.0/24
- FrontEnd Subnet has two web servers
- Backend Subment has two database servers
- frontendnsg
- backendnsg
  
### Steps
### Create the virtual network
- Create a resource group in specific region
- Create a Vnet and choose security according to need for test do not select anything
- Ip addresses, choose IPv4
- Choose Address space as above and add subnets as above
- Keep everything as default for testing purpose


### Create NSG
- frontendnsg and backendnsg
 
### Associate NSG to subnets
- From nsg
  Go to subnets and associate the nsg
- From subnets
  Go to Vnet -> subnets -> Network security group, then select the nsg

### Note: nsg can be used multiple times in the sam vnet or other vnets, it can be shared
 
