## Vnets
### Vnet Address Spaces
- TestVnet - 192.168.0.0/16
- FrontEnd Subnet - 192.168.1.0/24
- BackEnd Subnet- 192.168.2.0/24
- FrontEnd Subnet has two web servers, 1. RDP server, 2. Web Server
- Backend Subment has two database servers
- frontendnsg (RDP, TCP)
- backendnsg (SQL, RDP)
  
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

#### Note: nsg can be used multiple times in the sam vnet or other vnets, it can be shared

### Create inbound rules in frontend nsg to allow rdp and http traffic
- Go to Network Security Group
### RDP
- Go to inbound rules
- Add
- Source: Any(Any machine can connect)
- Port: * (Any port)
- Destination: Any (Any machine)
- Service: RDP
- Action: Allow
- Priority: 1000
- Name : As your choice
### HTTP
- Service: HTTP

### Create inbound rules in backend nsg to allow rdp and Mysql and deny all outgoing traffic to internet
- Create as created above, for service select Ms SQL

### Create outbound rule to block all traffic to internet
- Got to Outbound security rules
- Add
- Source: Any
- Destination: Service Tag
- Destination Service tag: Internet
- Service: Custom
- Destination port ranges: *
- Protocol : Any
- Priority: Less than "AllowInternetOutBound", eg. 1200

### Create Virtual Machine 
- Image: Windows Server 2022
- Architecture: X64
- Size: - 2 vcpus
- Username: username
- Password: password
- Public inbound ports: None (nsg attached with the subnet allows RDP, so no need to Allow here)
- Select the virtual network
- Select the subnet
- Public IP: Create new public ip - basic,static
- Delete public IP and NIC when VM is deleted: check
- Enable accelerated networking: Uncheck
- Everything : Default

### Connect to Virtual Machine
- Go to virtual machine
- Go to connect
- Download and open RDP file
- 


  
  
 
