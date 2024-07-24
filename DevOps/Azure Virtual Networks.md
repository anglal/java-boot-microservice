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
- NIC network security group: None (as it is already attached with subnet NSG)
- Delete public IP and NIC when VM is deleted: check
- Enable accelerated networking: Uncheck
- Everything : Default

### Connect to Virtual Machine
- Go to virtual machine
- Go to connect
- Download and open RDP file
- Connect 
- Install IIS webserver follow below:
- Go to serever manger/ could be already open
- Go to "Add roles and features"
- Installation Type: Role-based or feature-based installation
- Server Selection: Select a server from the server pool
- Server Roles: Web Server (IIS)
- Add features
- All next remainins: Default
- Install
- Wait until installation is complete.
- Once installation is complete, the inetpub/wwwroot will be created in C drive
- wwwroot will have websites/pages, default of the website

### Access the website
- http://public ip of vm -> http://123.234.12.89
- Or http://public ip of vm:<port> -> http://123.234.89:80
- You can make changes to the file named "iisstart" png file and test the changes

### Why are we able to accesss http?
- Because Virtual machine is in Vnet and using front end subnet, which has a nsg rule open for http
- Delete and test, you will not have access to http server in VM

### Where can NSG's be applied?
- NIC and Subnet

### Configure dns name in NIC
- Look for "Public IP addresses" in Azure Portal
- Find the public IP that is attached with NIC of the virtual machine
- Go to configuration
- Under DNS name label, give unique dns name

### NSG at NIC level
- Go to Network Interface of the virtual machine
- Go to settings
- Go to Network Security Group
- Select the NSG

Another way of associating NSG to NIC
- Go to Network Security Groups
- Go to Settings
- Go to Network interfaces
- Associate
- Select the specific NIC
### What happens if there are two NSG's, one at subnet level and one at NIC level?
- In above case it will fail because traffic is allowed by subnet but not by NIC.
- Both needs to allow or deny

### NIC is more specific and inner granular whereas subnet is more broader and outer

### Create new virtual machine as above for backend and attach the backend subnet

### Is traffic between vnet to vnet allowed?
- Yes
- Can use private ip or public ip both
  
### Network Watcher
- In portal, search for "Network Watcher"
- Go to "NSG diagnostics"
- Virtual Machine

### Network Watcher is very useful for connection troubleshooting
  
 
