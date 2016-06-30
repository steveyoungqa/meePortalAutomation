# Selenium
Designed for use with a selenium hub and node

## Launching a selenium hub
'java -jar selenium-server-standalone-2.46.0.jar -role hub'

## Launching a selenium node

Ensure the 'hubHost' variable in whichever NodeConfig.json file you wish to use is set to the IP address of your selenium hub (if running both on the same machine, leave it as local host).

'java -jar selenium.jar -role node -nodeConfig [insert whichever configuration you want here]'

## Testing on MEE

Go to the MEE folder within this repo, get the file for the platform you're working on, and place it in the location where MEE is installed:
Windows: %localappdata%\MEE

## Running tests

Ensure your selenium tests are configured to point towards the IP and port of the selenium hub
'http://[SeleniumHubIP]:4444/wd/hub'