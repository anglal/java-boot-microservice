## Vnets
### Vnet Address Spaces
- TestVnet - 192.168.0.0/16
- FrontEnd Subnet - 192.168.1.0/24
- BackEnd Subnet- 192.168.2.0/24
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
 
  ### Attach NSG to subnets
  
 
