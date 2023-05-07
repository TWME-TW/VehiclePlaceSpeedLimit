# VehiclePlaceSpeedLimit
A plugin to limit vehicle spawn rate.
Suitable for creative mode servers, to prevent malicious players from instantly placing a large number of minecarts and other entities (vehicles) that cause server lag.
## Installation
Put it in the plugins folder, and restart your server.
## Command
 - `/vpslreload` Reload VehiclePlaceSpeedLimit config.yml
## Permission
 - `vpsl.reload`
 default: op

## Config
```yaml=
debug: false
Config:
  # How many seconds between placing vehicles
  CreateCooldown: 0.7
Messages:
  CancelSpawn: '&7Cancels spawning a %vehicle%.'
  SpawnVehicle: '&fA %c%vehicle% &fhas been spawned.'
  TimeLeft: '&7Time left : %time%s'
  Reload: '&3Reloaded VehiclePlaceSpeedLimit config.yml'
```
