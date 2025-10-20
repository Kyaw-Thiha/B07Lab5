# B07Lab5
My friend Simon forced me into creating this repo. 
HELPPPPPPPPPPPPPPPPPPPPPP!!!!!!!

## Instructions
- Ensure `gradle` is installed on your machine.
- For each new lab, change the root project package in `settings.gradle`.

### Generate Gradle
Generate gradle wrappers.
```bash
gradle wrapper
```

### Build
```bash
./gradlew build
```

### Testing
For running test codes
```bash
./gradlew test
# single test class
./gradlew test --tests 'lab5.Lab5Tests'
# single test method
./gradlew test --tests 'lab5.Lab5Tests.someMethod'
```

### Doc Generation
```bash
./gradlew javadoc
```

