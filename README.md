# Description
This code base provides the frequent user cookies per day from a input file. 
# Pre-requisite
- Gradle
- java 8

# Instruction to Run the project
`./gradlew cookieAppRun -Pfilename=input-log.csv -Pdate=2018-12-09`

## Testing 
`./gradlew cookieAppRun -Pfilename=input-log.csv -Pdate=2018-12-09`
`./gradlew cookieAppRun -Pfilename=input-log.csv -Pdate=2018-12-08`
`./gradlew cookieAppRun -Pfilename=input-log.csv -Pdate=2018-12-07`

# Assumptions
- Only CSV is expected format
- Should have valid headers
- Should have valid date time format yyyy-MM-dd
- Date argument should have valid date time format yyyy-MM-dd
