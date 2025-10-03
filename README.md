# colab-flow-backend-play-framework
Play Framework 2.8.x Starter (Java 11 + SBT)

This is a verified starter project for building a Play Framework backend using **Java 11** and **SBT 1.8+**, pre-configured for full-stack development with React.

> Used in the [Pluralsight course](https://www.pluralsight.com/) on Full-Stack Java Development with Play Framework and React.

## Prerequisites

### Java 11

Check version:
```bash
java -version
```

Expected:
```bash
java version "11.0.x"
```

If not installed:

Download and install from: https://adoptium.net/en-GB/temurin/releases/
On macOS, set JAVA_HOME:
```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 11)
export PATH=$JAVA_HOME/bin:$PATH
```

### SBT (Scala Build Tool)
For Windows:
Download .msi installer:
https://github.com/sbt/sbt/releases/tag/v1.11.3
Install it

Verify:
```bash
sbt --script-version
```

For macOS:
Using .tgz:
```bash
curl -LO https://github.com/sbt/sbt/releases/download/v1.11.3/sbt-1.11.3.tgz
tar -xvzf sbt-1.11.3.tgz
sudo mv sbt /usr/local/share/sbt-1.11.3
sudo ln -s /usr/local/share/sbt-1.11.3/bin/sbt /usr/local/bin/sbt
```
 
## Getting Started
1. Clone the project:

  ```bash
  git clone https://github.com/yourusername/play-backend-starter.git
  cd play-backend-starter
  ```
2. Compile and run:
   ```bash
   sbt clean compile
   sbt run
   ```
3. Open in browser:
   http://localhost:9000


## Notes
- Uses H2 in-memory database with test username/password (admin/admin)
- Routes, filters, and dependencies preconfigured
- APIs, Web Sockets and all prod configs available in the git

## Next Steps 
Once this backend runs,:
- Built React app from UI folder of main branch
- Update config.js to point to your backend 
