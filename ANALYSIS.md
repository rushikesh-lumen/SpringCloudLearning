# Repository Analysis: SpringCloudLearning

> **Generated:** 2026-03-25  
> **Repository:** rushikesh-lumen/SpringCloudLearning  
> **Branch:** master

---

## 1. Executive Summary

This repository is a comprehensive Spring Cloud learning resource authored by Fang Zhipeng (forezp), covering all major Spring Cloud components through a series of progressive tutorial chapters. It demonstrates service registration and discovery, load balancing, circuit breaking, API gateway routing, distributed configuration, distributed tracing, and Alibaba Cloud integrations. The primary technology stack is Java 1.8 with Spring Boot (versions ranging from 1.5.2 to 2.4.4) and multiple Spring Cloud release trains (Dalston through 2020.0.2). The repository is severely outdated — every Spring Boot and Spring Cloud version in use has reached End-of-Life (EOL), all Netflix OSS components (Eureka, Ribbon, Hystrix, Zuul) are in maintenance/EOL state, and the codebase has not been migrated to Spring Boot 3.x or Java 17+.

| Metric | Value |
|--------|-------|
| Primary Language | Java 1.8 |
| Framework | Spring Boot (1.5.2 – 2.4.4) + Spring Cloud (Dalston – 2020.0.2) |
| Total Number of Files | 4,657 |
| Total Source Files | 349 (222 main + 127 test) |
| Total Lines of Code | ~9,930 |
| API Endpoints | ~99 (across all tutorial modules) |
| Test Files | 127 |
| Total Dependencies | 73+ unique Spring/Cloud starters |
| Outdated Dependencies | 73 / 100% (all versions are EOL) |
| Build Tool | Apache Maven (spring-boot-maven-plugin) |
| Estimated Test Coverage | ~5% (tests are context-load-only smoke tests) |

---

## 2. Current Architecture

### System Topology Diagram

```
┌─────────────────────────────────────────────────────────────────────────────────┐
│                         Spring Cloud Tutorial Ecosystem                          │
│                                                                                 │
│  ┌─────────────────┐    ┌──────────────────────────────────────────────────┐   │
│  │   Config Server  │    │              Service Discovery                   │   │
│  │  (Spring Cloud   │◄───│         Eureka Server / Consul / Nacos           │   │
│  │    Config)       │    │              (port: 8761/8889)                   │   │
│  └────────┬─────────┘    └───────┬─────────────────────────────────────────┘   │
│           │                      │                                              │
│           ▼                      ▼                                              │
│  ┌─────────────────────────────────────────────────────────────────────────┐   │
│  │                        API Gateway Layer                                 │   │
│  │         Zuul Proxy (chapters 1-13)  |  Spring Cloud Gateway (sc-f-*)    │   │
│  └───────────────────────────┬─────────────────────────────────────────────┘   │
│                               │                                                  │
│           ┌───────────────────┼───────────────────┐                            │
│           ▼                   ▼                   ▼                            │
│  ┌─────────────────┐ ┌─────────────────┐ ┌─────────────────┐                  │
│  │   service-hi    │ │  service-ribbon │ │  service-feign  │                  │
│  │  (port: 8762)   │ │  (port: 8764)   │ │  (port: 8765)   │                  │
│  └────────┬────────┘ └────────┬────────┘ └────────┬────────┘                  │
│           │                   │                   │                            │
│           └───────────────────┴───────────────────┘                            │
│                               │                                                  │
│           ┌───────────────────┼───────────────────┐                            │
│           ▼                   ▼                   ▼                            │
│  ┌─────────────────┐ ┌─────────────────┐ ┌─────────────────┐                  │
│  │   Hystrix /     │ │  Spring Cloud   │ │   Zipkin /       │                  │
│  │   Turbine       │ │    Bus (AMQP)   │ │   Sleuth         │                  │
│  │  (Dashboard)    │ │  (RabbitMQ)     │ │  (port: 9411)    │                  │
│  └─────────────────┘ └─────────────────┘ └─────────────────┘                  │
│                                                                                 │
│  ┌─────────────────────────────────────────────────────────────────────────┐   │
│  │              Spring Cloud Alibaba (Greenwich / 2020 series)              │   │
│  │   Nacos Discovery  |  Nacos Config  |  Sentinel Circuit Breaker          │   │
│  └─────────────────────────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────────────────────────┘
```

### Full Technology Stack

| Layer | Technology | Version | Status |
|-------|-----------|---------|--------|
| Language | Java | 1.8 | ❌ EOL |
| Build | Apache Maven | 3.x (wrapper) | ✅ Current |
| Core Framework | Spring Boot | 1.5.2.RELEASE | ❌ EOL |
| Core Framework | Spring Boot | 2.0.3.RELEASE | ❌ EOL |
| Core Framework | Spring Boot | 2.0.5.RELEASE | ❌ EOL |
| Core Framework | Spring Boot | 2.1.0.RELEASE | ❌ EOL |
| Core Framework | Spring Boot | 2.1.4.RELEASE | ❌ EOL |
| Core Framework | Spring Boot | 2.4.4 | ❌ EOL |
| Cloud Orchestration | Spring Cloud Dalston | RC1 / RELEASE | ❌ EOL |
| Cloud Orchestration | Spring Cloud Finchley | RELEASE / SR1 / SR2 | ❌ EOL |
| Cloud Orchestration | Spring Cloud Greenwich | RELEASE | ❌ EOL |
| Cloud Orchestration | Spring Cloud 2020.x | 2020.0.2 | ❌ EOL |
| Service Discovery | Spring Cloud Netflix Eureka | Dalston/Finchley/Greenwich | ❌ EOL |
| Service Discovery | Consul | Dalston.RELEASE | ❌ EOL |
| Service Discovery | Nacos Discovery | 0.9.0.RELEASE / Greenwich | ⚠️ Outdated |
| Load Balancing | Netflix Ribbon | Dalston/Finchley | ❌ EOL |
| Load Balancing | Spring Cloud LoadBalancer | 2020.0.2 | ⚠️ Outdated |
| Circuit Breaker | Netflix Hystrix | Dalston/Finchley | ❌ EOL |
| Circuit Breaker | Alibaba Sentinel | Greenwich/2020 | ⚠️ Outdated |
| API Gateway | Netflix Zuul | Dalston/Finchley | ❌ EOL |
| API Gateway | Spring Cloud Gateway | Finchley.SR1 / 2020.0.2 | ⚠️ Outdated |
| Service Calls | OpenFeign (spring-cloud-starter-feign) | Dalston | ❌ EOL |
| Service Calls | Spring Cloud OpenFeign | Finchley/2020 | ⚠️ Outdated |
| Distributed Config | Spring Cloud Config Server | Dalston/Finchley/Greenwich | ❌ EOL |
| Distributed Tracing | Spring Cloud Sleuth + Zipkin | Dalston/Finchley/Greenwich | ❌ EOL |
| Distributed Tracing | Spring Cloud Sleuth + Zipkin | 2020.0.2 | ⚠️ Outdated |
| Message Bus | Spring Cloud Bus (AMQP/RabbitMQ) | Dalston/Finchley | ❌ EOL |
| Monitoring | Spring Boot Admin | 2.1.0 | ❌ EOL |
| Hystrix Dashboard | Hystrix Dashboard + Turbine | Dalston/Finchley | ❌ EOL |
| Alibaba Cloud | Spring Cloud Alibaba | 0.9.0.RELEASE | ❌ EOL |
| Alibaba Cloud | Spring Cloud Alibaba | 2020.0.RC1 / 2021.1 | ⚠️ Outdated |
| Containerization | Docker (frolvlad/alpine-oraclejdk8) | slim | ❌ EOL |
| CI/CD | None configured | N/A | ❌ Missing |
| Container Orchestration | None configured | N/A | ❌ Missing |

### Project Structure Overview

```
SpringCloudLearning/
├── README.md                          # Tutorial index with blog links
│
├── chapter1–14/                       # D版本 (Dalston) — Spring Boot 1.5.2 + Spring Cloud Dalston.RC1
│   ├── chapter1/                      # Eureka server + service-hi (discovery basics)
│   ├── chapter2/                      # Ribbon load balancing (RestTemplate)
│   ├── chapter3/                      # OpenFeign service consumer
│   ├── chapter4/                      # Hystrix circuit breaker
│   ├── chapter5/                      # Zuul API gateway
│   ├── chapter6/                      # Spring Cloud Config (git-backed)
│   ├── chapter7/                      # Config high availability (Eureka + Config)
│   ├── chapter8/                      # Spring Cloud Bus (AMQP/RabbitMQ)
│   ├── chapter9/                      # Sleuth distributed tracing + Zipkin
│   ├── chapter10/                     # High-availability Eureka (peer replication)
│   ├── chapter10-5-jdbc/              # Config Server with JDBC backend
│   ├── chapter11/                     # Docker deployment
│   ├── chapter11-2/                   # Docker deployment variant
│   ├── chapter12/                     # Hystrix Dashboard
│   ├── chapter13/                     # Hystrix Turbine (aggregation)
│   └── chapter14/                     # Consul service discovery
│
├── chapter-sleuth*/                   # Dalston Sleuth variants (5 modules)
│   ├── chapter-sleuth/                # Basic Sleuth + Zipkin
│   ├── chapter-sleuth-mysql/          # Sleuth with MySQL storage
│   ├── chapter-sleuth-stream/         # Sleuth via RabbitMQ stream
│   ├── chapter-sleuth-stream-mysql/   # Sleuth stream with MySQL
│   └── chapter-sleuth-stream-elasticsearch/ # Sleuth stream with ES
│
├── sc-f-chapter1–13/                  # F版本 (Finchley) — Spring Boot 2.0.3 + Spring Cloud Finchley
│   ├── sc-f-chapter1/                 # Eureka (Finchley)
│   ├── sc-f-chapter2/                 # Ribbon (Finchley)
│   ├── sc-f-chapter3/                 # OpenFeign (Finchley)
│   ├── sc-f-chapter4/                 # Hystrix (Finchley)
│   ├── sc-f-chapter5/                 # Zuul (Finchley)
│   ├── sc-f-chapter6–8/              # Config + Bus (Finchley)
│   ├── sc-f-chapter9/                 # Sleuth + Zipkin (Finchley)
│   ├── sc-f-chapter10/               # HA Eureka (Finchley)
│   ├── sc-f-chapter12–13/            # Hystrix Dashboard + Turbine
│   ├── sc-f-boot-admin/              # Spring Boot Admin
│   ├── sc-f-boot-admin-cloud/        # Boot Admin with service discovery
│   └── sc-f-gateway-*/               # Spring Cloud Gateway (5 variants)
│
├── springcloud-alibaba/               # G版本 (Greenwich) — Spring Boot 2.1.4 + Greenwich
│   ├── nacos-discovery/               # Nacos service discovery
│   ├── nacos-config/                  # Nacos configuration center
│   └── nacos-discovery-sentinel/     # Nacos + Alibaba Sentinel
│
├── sc-2020-chapter1–4/               # 2020版本 — Spring Boot 2.4.4 + Spring Cloud 2020.0.2
│   ├── sc-2020-chapter1/             # Nacos registration + config
│   ├── sc-2020-chapter2/             # Spring Cloud Gateway
│   ├── sc-2020-chapter3/             # Sentinel circuit breaker
│   └── sc-2020-chapter4/             # Sleuth + Zipkin (2020)
│
└── respo/                             # Spring Cloud Config git repository files
```

### API Surface

All endpoints are tutorial demonstration endpoints. Below is a representative sample across modules:

| Module / Service | Method | Path | Description |
|-----------------|--------|------|-------------|
| service-hi (all chapters) | GET | `/hi` | Returns greeting with port |
| service-hi (chapter9) | GET | `/info` | Returns service info |
| service-miya (chapter9) | GET | `/miya` | Returns miya greeting |
| service-ribbon | GET | `/hi` | Ribbon-proxied call to service-hi |
| service-feign / HiController | GET | `/hi` | Feign-proxied call to service-hi |
| service-feign / HiController | GET | `/hi-feign` | Feign consumer endpoint (2020 series) |
| consumer (sc-2020-*) | GET | `/hi-feign` | OpenFeign consumer |
| consumer (sc-2020-*) | GET | `/hi-resttemplate` | RestTemplate consumer |
| provider (sc-2020-*) | GET | `/hi` | Provider endpoint |
| user-service (chapter-sleuth) | GET | `/user/hi` | Sleuth-traced user endpoint |
| config-client (chapter6-8) | GET | `/hi` | Config-refreshable endpoint |
| consul-miya (chapter14) | GET | `/hi` | Consul-registered service endpoint |
| nacos-provider | GET | `/hi` | Nacos-registered provider |
| nacos-provider | GET | `/services` | Lists all services |
| nacos-config | GET | `/username` | Reads Nacos config value |

### External Integrations

| Service | Purpose | Used In |
|---------|---------|---------|
| Netflix Eureka | Service registry / discovery | chapter1–13, sc-f-chapter1–13, chapter-sleuth* |
| HashiCorp Consul | Service registry | chapter14 |
| Alibaba Nacos | Service registry + config center | springcloud-alibaba, sc-2020-chapter1–4 |
| Alibaba Sentinel | Circuit breaker / rate limiting | springcloud-alibaba, sc-2020-chapter3 |
| RabbitMQ (AMQP) | Message bus + Sleuth stream | chapter8, sc-f-chapter8, chapter-sleuth-stream* |
| Zipkin Server | Distributed tracing collector | chapter9, chapter-sleuth*, sc-f-chapter9, sc-2020-chapter4 |
| GitHub Git Repository | Spring Cloud Config backend | chapter6–8, respo/ |
| Elasticsearch | Sleuth trace storage | chapter-sleuth-stream-elasticsearch |
| MySQL | Sleuth trace storage / Config JDBC | chapter-sleuth-*-mysql, chapter10-5-jdbc |
| Spring Boot Admin | Application monitoring | sc-f-boot-admin, sc-f-boot-admin-cloud |

### Data Layer

| Storage | Usage | Module |
|---------|-------|--------|
| In-memory (none) | No persistent data; all demo state is ephemeral | All |
| MySQL | Zipkin trace storage via JDBC | chapter-sleuth-stream-mysql, chapter-sleuth-mysql |
| Elasticsearch | Zipkin trace storage via ES | chapter-sleuth-stream-elasticsearch |
| Git (GitHub) | Spring Cloud Config external configuration | chapter6, chapter7, chapter8, respo/ |
| JDBC (H2/MySQL) | Spring Cloud Config JDBC backend | chapter10-5-jdbc |
| Nacos | Distributed configuration storage | springcloud-alibaba, sc-2020-chapter1 |

### Configuration Management

| Approach | Detail | Location |
|----------|--------|---------|
| `application.yml` | Per-service static configuration | All services |
| `bootstrap.yml` / `bootstrap.properties` | Early-init config (Config Server URL, app name) | All config clients |
| Spring Cloud Config (git) | Externalized git-backed properties | chapter6–8, respo/ |
| Spring Cloud Config (JDBC) | Database-backed properties | chapter10-5-jdbc |
| Nacos Config | Alibaba Nacos-backed config | springcloud-alibaba, sc-2020-chapter1 |
| Hardcoded credentials | Git config username/password fields left empty | chapter6/config-server |
| No secrets management | No Vault, no encrypted values | All |
| No environment profiles | Only `dev` profile used in some Config clients | chapter6–8 |

---

## 3. Modernization Blockers

### Critical Blockers

#### CB-1: All Spring Boot Versions Are EOL with Known CVEs

| Attribute | Detail |
|-----------|--------|
| Severity | CRITICAL |
| File(s) | All `pom.xml` files (172 total) |
| Risk | Active security vulnerabilities in Spring Framework, Tomcat, and transitive deps |
| Recommended Action | Upgrade to Spring Boot 3.3.x (LTS) + Spring Cloud 2023.x |

Spring Boot 1.5.2.RELEASE (EOL Aug 2019) is the oldest version in use. It contains numerous unpatched vulnerabilities including Spring Framework remote code execution CVEs (CVE-2022-22965 "Spring4Shell"), deserialization issues, and Tomcat vulnerabilities. All 6 Spring Boot versions in this repository are EOL.

#### CB-2: Java 1.8 — End of Free Public Updates

| Attribute | Detail |
|-----------|--------|
| Severity | CRITICAL |
| File(s) | All `pom.xml` files (java.version=1.8) |
| Risk | No security patches; Spring Boot 3.x requires Java 17 minimum |
| Recommended Action | Upgrade to Java 21 (LTS) |

#### CB-3: Netflix Hystrix — End of Life

| Attribute | Detail |
|-----------|--------|
| Severity | CRITICAL |
| File(s) | chapter4, chapter12, chapter13, sc-f-chapter4, sc-f-chapter12, sc-f-chapter13 (and all pom.xml with `spring-cloud-starter-hystrix`) |
| Risk | No bug fixes, no security patches; circuit breaker functionality is unreliable in modern JVMs |
| Recommended Action | Replace with Resilience4j (`spring-cloud-starter-circuitbreaker-resilience4j`) |

#### CB-4: Netflix Ribbon — Removed in Spring Cloud 2021.x

| Attribute | Detail |
|-----------|--------|
| Severity | CRITICAL |
| File(s) | chapter2, sc-f-chapter2, all `spring-cloud-starter-ribbon` usages |
| Risk | Completely removed from Spring Cloud; incompatible with Spring Boot 3.x |
| Recommended Action | Replace with Spring Cloud LoadBalancer |

#### CB-5: Netflix Zuul — Removed in Spring Cloud 2021.x

| Attribute | Detail |
|-----------|--------|
| Severity | CRITICAL |
| File(s) | chapter5, sc-f-chapter5, all `spring-cloud-starter-zuul` usages |
| Risk | Completely removed from Spring Cloud; blocking/Servlet-based, incompatible with reactive stack |
| Recommended Action | Migrate to Spring Cloud Gateway |

#### CB-6: Deprecated `@EnableZipkinServer` — Removed in Spring Cloud 3.x

| Attribute | Detail |
|-----------|--------|
| Severity | CRITICAL |
| File(s) | chapter9/server-zipkin, chapter-sleuth/zipkin-server (all `ZipkinServerApplication.java`) |
| Risk | Cannot compile or run on Spring Cloud Sleuth 3.x; standalone Zipkin server required |
| Recommended Action | Replace with standalone Zipkin distribution or Micrometer Tracing + OTLP |

#### CB-7: Obsolete Docker Base Image (`frolvlad/alpine-oraclejdk8`)

| Attribute | Detail |
|-----------|--------|
| Severity | CRITICAL |
| File(s) | chapter11/eureka-server/Dockerfile, chapter11/service-hi/Dockerfile, chapter11-2/eureka-server/Dockerfile, chapter11-2/service-hi/Dockerfile |
| Risk | Oracle JDK 8 image has known CVEs; image is unmaintained and may be unavailable |
| Recommended Action | Replace with `eclipse-temurin:21-jre-alpine` or use multi-stage build |

---

### Major Issues

#### MI-1: Spring Cloud Config with Empty Git Credentials

The Config Server in chapter6–8 uses `spring.cloud.config.server.git.username=` and `spring.cloud.config.server.git.password=` with empty values. This means it either relies on public repo access or will fail for private repositories. There is no integration with a secrets manager.

**Recommended fix:** Use SSH key authentication or integrate Spring Cloud Vault for credential management.

#### MI-2: `spring-cloud-starter-eureka` (deprecated artifact ID)

The old `spring-cloud-starter-eureka` artifact ID was renamed to `spring-cloud-starter-netflix-eureka-client` in Edgware. All Dalston-era modules (chapter1–14, chapter-sleuth*) still use the deprecated ID. While tolerated in Dalston, it is absent in Spring Cloud 2020+.

**Recommended fix:** Update artifact IDs and migrate to Spring Cloud 2023.x.

#### MI-3: No CI/CD Pipeline

There are no GitHub Actions workflows, no Jenkinsfile, no CircleCI config, and no other CI/CD configuration files. The repository cannot be automatically built, tested, or deployed.

**Recommended fix:** Add a GitHub Actions workflow with Java 21, Maven build, and automated tests for each module group.

#### MI-4: `spring-cloud-starter-feign` (deprecated)

The `spring-cloud-starter-feign` artifact was renamed to `spring-cloud-starter-openfeign`. Still used in chapter3, chapter4.

**Recommended fix:** Update to `spring-cloud-starter-openfeign`.

#### MI-5: Spring Cloud Alibaba Pre-Release Version

`springcloud-alibaba/` uses version `0.9.0.RELEASE` which is pre-1.0 and does not follow standard version alignment with Spring Cloud. The 2020-series uses `2020.0.RC1` (release candidate).

**Recommended fix:** Upgrade to Spring Cloud Alibaba `2023.0.x` to align with current Spring Cloud 2023.x.

#### MI-6: No Application Security (Authentication/Authorization)

None of the services implement Spring Security. All endpoints are fully public with no authentication, no HTTPS, and no JWT/OAuth2 integration.

**Recommended fix:** Add Spring Security with JWT or OAuth2 to at least the gateway layer services.

#### MI-7: Spring Boot Admin Outdated

`sc-f-boot-admin` uses Spring Boot Admin 2.1.0 (EOL). Latest is 3.4.x.

**Recommended fix:** Upgrade to Spring Boot Admin 3.4.x aligned with Spring Boot 3.3.x.

---

### Moderate Issues

#### MOI-1: Hardcoded Hostnames and Ports

All `application.yml` and `bootstrap.yml` files hardcode `localhost` and specific ports. This prevents deployment in any cloud or container environment without manual reconfiguration.

**Recommended action:** Use environment variables (`${EUREKA_HOST:localhost}`) for all hostnames and ports.

#### MOI-2: Test Coverage Is Effectively Zero

All 127 test files are generated Spring Boot smoke tests (`@SpringBootTest` that only verify context loads). There are no unit tests, integration tests, or tests that validate business logic or API contracts.

**Recommended action:** Add meaningful JUnit 5 + Mockito unit tests and Spring MockMvc integration tests.

#### MOI-3: Module Duplication Across Tutorial Versions

The same functionality is implemented across 4–5 different tutorial versions (D版本, F版本, Alibaba版本, 2020版本) with significant code duplication. This increases maintenance burden substantially.

**Recommended action:** Consider consolidating to a single current version or using Git tags/branches per version.

#### MOI-4: `.DS_Store` Files Committed

macOS `.DS_Store` files are present in chapter13/, chapter-sleuth/, and other directories.

**Recommended action:** Add `.DS_Store` to `.gitignore` and remove existing occurrences.

#### MOI-5: `spring-cloud-starter-zipkin` with `version>RELEASE</version>`

Several `pom.xml` files specify `<version>RELEASE</version>` (the keyword, not a literal version) for `spring-cloud-starter-zipkin`. This is non-deterministic and will resolve to whatever Maven considers "latest release", which changes unpredictably.

**Recommended action:** Pin to explicit version numbers or manage through the BOM.

#### MOI-6: Missing `.gitignore` at Root Level

There is no `.gitignore` at the repository root. Only individual module directories have `.gitignore` files. This leaves the root-level build artifacts unprotected.

**Recommended action:** Add a comprehensive root-level `.gitignore`.

---

## 4. Target-State Design

### Target Technology Stack

| Component | Current | Target | Notes |
|-----------|---------|--------|-------|
| Java | 1.8 | 21 (LTS) | Spring Boot 3.x requires minimum Java 17 |
| Spring Boot | 1.5.2 – 2.4.4 | 3.3.x | Active LTS; next LTS: 3.4.x |
| Spring Cloud | Dalston – 2020.0.2 | 2023.x | Latest supported train |
| Spring Cloud Alibaba | 0.9.0 – 2021.1 | 2023.0.x | Aligned with Spring Cloud 2023.x |
| Service Discovery | Netflix Eureka (EOL) | Nacos 2.x or Eureka (Netflix maintained) | Nacos preferred for modern setups |
| Load Balancing | Netflix Ribbon (removed) | Spring Cloud LoadBalancer | Built into Spring Cloud 2020+ |
| Circuit Breaker | Netflix Hystrix (EOL) | Resilience4j | Official Spring Cloud recommendation |
| API Gateway | Netflix Zuul (removed) | Spring Cloud Gateway | Reactive, actively maintained |
| Service Calls | spring-cloud-starter-feign | Spring Cloud OpenFeign 4.x | Renamed and updated |
| Distributed Tracing | Spring Cloud Sleuth + Zipkin | Micrometer Tracing + Zipkin / OTLP | Sleuth removed in Spring Cloud 2022+ |
| Config Management | Spring Cloud Config (git) | Spring Cloud Config 4.x or Nacos Config | Keep or consolidate with Nacos |
| Message Bus | Spring Cloud Bus + RabbitMQ | Spring Cloud Bus 4.x + RabbitMQ 3.x | Keep pattern; upgrade versions |
| Monitoring | Spring Boot Admin 2.1 | Spring Boot Admin 3.4.x | Align with Spring Boot 3.x |
| Docker Base | frolvlad/alpine-oraclejdk8 | eclipse-temurin:21-jre-alpine | Official OpenJDK, actively patched |
| CI/CD | None | GitHub Actions | Add multi-module build + test matrix |
| Container Orchestration | None | Docker Compose (dev) / K8s (prod) | Containerize all services |
| Secrets Management | None (plain text) | Spring Cloud Vault or env variables | Remove hardcoded credentials |

### Target Architecture Diagram

```
┌─────────────────────────────────────────────────────────────────────────────────┐
│                       Target Spring Cloud Architecture (2023.x)                  │
│                                                                                 │
│  ┌──────────────────────────────────────────────────────────────────────────┐  │
│  │                    CI/CD Pipeline (GitHub Actions)                        │  │
│  │         Build → Test → Docker Build → Container Registry → Deploy         │  │
│  └──────────────────────────────────────────────────────────────────────────┘  │
│                                                                                 │
│  ┌─────────────────┐    ┌──────────────────────────────────────────────────┐  │
│  │  Nacos Config   │    │           Nacos Discovery Server                  │  │
│  │   (2023.0.x)    │◄───│              (port: 8848)                         │  │
│  └────────┬────────┘    └──────────────────────┬───────────────────────────┘  │
│           │                                      │                               │
│           ▼                                      ▼                               │
│  ┌──────────────────────────────────────────────────────────────────────────┐  │
│  │                    Spring Cloud Gateway (reactive)                        │  │
│  │     Rate Limiting | Auth Filter | Circuit Breaker | Load Balancing        │  │
│  └───────────────────────────────┬──────────────────────────────────────────┘  │
│                                   │                                              │
│           ┌───────────────────────┼──────────────────────┐                     │
│           ▼                       ▼                       ▼                     │
│  ┌─────────────────┐   ┌─────────────────┐   ┌──────────────────┐             │
│  │   service-hi    │   │  service-feign  │   │    provider      │             │
│  │  (Java 21,      │   │  (OpenFeign 4x) │   │  (Java 21, SB3)  │             │
│  │   SB 3.3.x)     │   │                 │   │                  │             │
│  └────────┬────────┘   └────────┬────────┘   └────────┬─────────┘             │
│           │                     │                      │                        │
│  ┌────────┴─────────────────────┴──────────────────────┴─────────────────────┐ │
│  │                   Resilience4j Circuit Breaker + Spring Cloud LoadBalancer  │ │
│  └─────────────────────────────────────────────────────────────────────────────┘ │
│                                                                                 │
│  ┌──────────────┐  ┌──────────────────────┐  ┌─────────────────────────────┐  │
│  │ Spring Boot  │  │  Micrometer Tracing  │  │  Spring Cloud Bus           │  │
│  │  Admin 3.4   │  │  + Zipkin / OTLP     │  │  + RabbitMQ 3.x            │  │
│  └──────────────┘  └──────────────────────┘  └─────────────────────────────┘  │
└─────────────────────────────────────────────────────────────────────────────────┘
```

### Configuration & Secrets Strategy

| Area | Target Approach |
|------|----------------|
| Application config | `application.yml` with `${ENV_VAR:default}` pattern for all hostnames/ports |
| Secrets | Spring Cloud Vault or Kubernetes Secrets / environment variables |
| Config Server | Spring Cloud Config 4.x with encrypted property values (`{cipher}...`) |
| Nacos Config | Use Nacos namespace isolation per environment (dev/staging/prod) |
| Git credentials | SSH key authentication for Config Server git backend |
| Docker secrets | Use Docker Compose secrets or Kubernetes Secrets (never bake into image) |

---

## 5. Migration Sequence

### Phase 1 — Critical (Security & EOL)

| Step | Task | Effort | Risk |
|------|------|--------|------|
| 1.1 | Upgrade Java from 1.8 to 21 (LTS) in all `pom.xml` and Dockerfiles | Medium (1–3 days) | Medium — may expose deprecated API usage |
| 1.2 | Upgrade Spring Boot from 1.5.2/2.0.3/2.1.4/2.4.4 to 3.3.x | High (1+ weeks) | High — breaking changes in Spring Boot 3.x (Jakarta EE namespace migration) |
| 1.3 | Migrate `javax.*` imports to `jakarta.*` namespace | Medium (1–3 days) | Medium — mechanical but widespread |
| 1.4 | Upgrade Spring Cloud from Dalston/Finchley/Greenwich/2020 to 2023.x | High (1+ weeks) | High — removed components require replacements |
| 1.5 | Replace Netflix Ribbon with Spring Cloud LoadBalancer | Medium (1–3 days) | Low — API is similar |
| 1.6 | Replace Netflix Hystrix with Resilience4j (`spring-cloud-starter-circuitbreaker-resilience4j`) | High (1+ weeks) | Medium — different API and configuration model |
| 1.7 | Replace Netflix Zuul with Spring Cloud Gateway | High (1+ weeks) | Medium — requires reactive programming model |
| 1.8 | Replace `@EnableZipkinServer` with standalone Zipkin server or Micrometer Tracing | Medium (1–3 days) | Low — standalone Zipkin is drop-in |
| 1.9 | Replace Docker base image `frolvlad/alpine-oraclejdk8` with `eclipse-temurin:21-jre-alpine` | Low (1–4 hours) | Low |
| 1.10 | Remove hardcoded empty Git credentials; use SSH or Vault | Low (1–4 hours) | Low |

### Phase 2 — Modernization (Frameworks & Dependencies)

| Step | Task | Effort | Risk |
|------|------|--------|------|
| 2.1 | Rename `spring-cloud-starter-feign` to `spring-cloud-starter-openfeign` | Low (1–4 hours) | Low |
| 2.2 | Rename `spring-cloud-starter-eureka` to `spring-cloud-starter-netflix-eureka-client` | Low (1–4 hours) | Low |
| 2.3 | Upgrade Spring Cloud Alibaba from 0.9.0/2020.RC1/2021.1 to 2023.0.x | Medium (1–3 days) | Medium — API changes in Nacos client |
| 2.4 | Upgrade Spring Boot Admin to 3.4.x | Low (1–4 hours) | Low |
| 2.5 | Replace `spring-cloud-starter-sleuth` with Micrometer Tracing (`micrometer-tracing-bridge-brave` + `zipkin-reporter-brave`) | Medium (1–3 days) | Medium — new API, different configuration |
| 2.6 | Replace `spring-cloud-sleuth-zipkin-stream` with OTLP or Zipkin/Brave | Medium (1–3 days) | Medium |
| 2.7 | Pin all `<version>RELEASE</version>` to explicit version numbers | Low (1–4 hours) | Low |
| 2.8 | Replace all hardcoded `localhost` with `${ENV_VAR:localhost}` environment variable pattern | Medium (1–3 days) | Low |
| 2.9 | Consolidate 4-version duplication into single current-version codebase using Git tags | High (1+ weeks) | Medium |
| 2.10 | Add multi-stage Docker builds with non-root user | Low (1–4 hours) | Low |

### Phase 3 — Quality (Testing & DevOps)

| Step | Task | Effort | Risk |
|------|------|--------|------|
| 3.1 | Add GitHub Actions CI workflow for Java 21 + Maven build | Low (1–4 hours) | Low |
| 3.2 | Add meaningful unit tests with JUnit 5 + Mockito (target 60%+ coverage) | High (1+ weeks) | Low |
| 3.3 | Add Spring MockMvc / WebTestClient integration tests for API endpoints | High (1+ weeks) | Low |
| 3.4 | Add Docker Compose file for local multi-service development | Medium (1–3 days) | Low |
| 3.5 | Add root-level `.gitignore` with `target/`, `.DS_Store`, `*.class` | Low (1–4 hours) | Low |
| 3.6 | Add Spring Security (JWT/OAuth2) to gateway and service layers | High (1+ weeks) | Medium |
| 3.7 | Integrate Spring Cloud Vault for secrets management | Medium (1–3 days) | Medium |
| 3.8 | Add HTTPS/TLS configuration to all services | Medium (1–3 days) | Medium |
| 3.9 | Add Kubernetes manifests (Deployment, Service, ConfigMap, Secret) | High (1+ weeks) | Medium |
| 3.10 | Add contract testing with Spring Cloud Contract | High (1+ weeks) | Low |

---

## 6. Risks and Dependencies

### Technical Risks

| Risk | Probability | Impact | Mitigation |
|------|-------------|--------|-----------|
| Jakarta EE namespace migration breaks compile | HIGH | HIGH | Use OpenRewrite Spring Boot 3.x migration recipe |
| Hystrix → Resilience4j API incompatibility requires full rewrite | HIGH | HIGH | Allocate dedicated sprint for circuit breaker migration |
| Reactive Gateway requires learning reactive programming | MEDIUM | MEDIUM | Provide team training; start with simple route config |
| Nacos client API changed between 0.9.0 and 2023.0.x | HIGH | MEDIUM | Test against Nacos 2.x server; review migration guide |
| Sleuth API completely removed in Spring Cloud 2022+ | HIGH | HIGH | Migrate to Micrometer Tracing; different configuration model |
| Module duplication means 5x migration effort | HIGH | HIGH | Consolidate to single version before migrating |

### Security Risks

| Risk | Severity | Impact | Mitigation |
|------|----------|--------|-----------|
| Spring Boot 1.5.2 CVEs (including CVE-2022-22965 Spring4Shell) | CRITICAL | RCE possible if deployed | Upgrade immediately to Spring Boot 3.3.x |
| Empty Git credentials in config server | HIGH | Config server bypassed or leaks config | Use SSH keys or Vault |
| No authentication on any endpoint | HIGH | Unrestricted access to all services | Add Spring Security + OAuth2 |
| No HTTPS/TLS | HIGH | Man-in-the-middle possible | Enable TLS on all services |
| Outdated Docker base image with known CVEs | HIGH | Container escape / privilege escalation | Upgrade to eclipse-temurin:21-jre-alpine |
| Hardcoded `localhost` and port numbers | MEDIUM | Predictable attack surface | Externalize via environment variables |
| `<version>RELEASE</version>` non-deterministic resolution | MEDIUM | Unexpected dependency version changes | Pin to explicit versions |

### Operational Risks

| Risk | Probability | Impact | Mitigation |
|------|-------------|--------|-----------|
| No CI/CD means broken builds go undetected | HIGH | HIGH | Add GitHub Actions immediately |
| No container orchestration for multi-service scenarios | HIGH | HIGH | Add Docker Compose for local dev |
| No health checks in Dockerfiles | HIGH | MEDIUM | Add `HEALTHCHECK` to all Dockerfiles |
| Hardcoded ports cause conflicts in shared environments | MEDIUM | MEDIUM | Externalize all ports via env vars |
| No log aggregation configuration | MEDIUM | MEDIUM | Add structured logging (JSON) + ELK/Loki |

### External Dependencies

| Item | Severity | Impact | Mitigation |
|------|----------|--------|-----------|
| Netflix OSS GitHub repositories (archived) | HIGH | No upstream fixes | Migrate to supported alternatives |
| `github.com/forezp/SpringcloudConfig` git repo | HIGH | Config Server fails if repo deleted | Fork and self-host; or migrate to Nacos |
| `frolvlad/alpine-oraclejdk8` Docker image | HIGH | Image may be pulled or become unavailable | Migrate to official eclipse-temurin images |
| Alibaba Nacos (external service) | MEDIUM | Discovery + config unavailable if Nacos down | Add Nacos HA; or use Spring Cloud Consul |
| RabbitMQ (external broker) | MEDIUM | Message bus and Sleuth stream unavailable | Add connection retry; document RabbitMQ setup |

---

## 7. Recommended Next Actions

| Priority | Action | Owner | Phase |
|----------|--------|-------|-------|
| 🔴 | Upgrade Spring Boot to 3.3.x and Java to 21 across all active modules | Backend Team | Phase 1 |
| 🔴 | Migrate `javax.*` → `jakarta.*` namespace (Spring Boot 3.x breaking change) | Backend Team | Phase 1 |
| 🔴 | Replace Netflix Hystrix with Resilience4j | Backend Team | Phase 1 |
| 🔴 | Replace Netflix Zuul with Spring Cloud Gateway | Backend Team | Phase 1 |
| 🔴 | Replace Netflix Ribbon with Spring Cloud LoadBalancer | Backend Team | Phase 1 |
| 🔴 | Replace deprecated Docker base image with `eclipse-temurin:21-jre-alpine` | DevOps | Phase 1 |
| 🔴 | Upgrade Spring Cloud to 2023.x | Backend Team | Phase 1 |
| 🟠 | Add GitHub Actions CI/CD workflow | DevOps | Phase 3 |
| 🟠 | Migrate Spring Cloud Sleuth to Micrometer Tracing | Backend Team | Phase 2 |
| 🟠 | Upgrade Spring Cloud Alibaba to 2023.0.x | Backend Team | Phase 2 |
| 🟠 | Add Spring Security (JWT/OAuth2) to gateway services | Security Team | Phase 3 |
| 🟠 | Replace `<version>RELEASE</version>` with pinned explicit versions | Backend Team | Phase 2 |
| 🟠 | Externalize all hostnames and ports via environment variables | Backend Team | Phase 2 |
| 🟡 | Add meaningful JUnit 5 unit + integration tests (60%+ coverage) | QA Team | Phase 3 |
| 🟡 | Add Docker Compose for local multi-service dev environment | DevOps | Phase 3 |
| 🟡 | Consolidate 4 tutorial versions into single current-version codebase | Backend Team | Phase 2 |
| 🟡 | Add root-level `.gitignore`; remove `.DS_Store` files | Any | Phase 3 |
| 🟡 | Add Spring Cloud Vault integration for secrets | Security Team | Phase 3 |
| 🟡 | Add Kubernetes manifests for production deployments | DevOps | Phase 3 |

---

## 8. Dependency Inventory

### Spring Boot Parent / BOM

| Package/Artifact | Current Version | Latest Stable | Status | Action |
|-----------------|-----------------|--------------|--------|--------|
| spring-boot-starter-parent | 1.5.2.RELEASE | 3.3.x | ❌ EOL | Upgrade to 3.3.x |
| spring-boot-starter-parent | 2.0.3.RELEASE | 3.3.x | ❌ EOL | Upgrade to 3.3.x |
| spring-boot-starter-parent | 2.0.5.RELEASE | 3.3.x | ❌ EOL | Upgrade to 3.3.x |
| spring-boot-starter-parent | 2.1.0.RELEASE | 3.3.x | ❌ EOL | Upgrade to 3.3.x |
| spring-boot-starter-parent | 2.1.4.RELEASE | 3.3.x | ❌ EOL | Upgrade to 3.3.x |
| spring-boot-starter-parent | 2.4.4 | 3.3.x | ❌ EOL | Upgrade to 3.3.x |
| spring-boot-dependencies | 2.4.4 | 3.3.x | ❌ EOL | Upgrade to 3.3.x |

### Spring Cloud BOM

| Package/Artifact | Current Version | Latest Stable | Status | Action |
|-----------------|-----------------|--------------|--------|--------|
| spring-cloud-dependencies | Dalston.RC1 | 2023.0.x | ❌ EOL | Upgrade |
| spring-cloud-dependencies | Dalston.RELEASE | 2023.0.x | ❌ EOL | Upgrade |
| spring-cloud-dependencies | Finchley.RELEASE | 2023.0.x | ❌ EOL | Upgrade |
| spring-cloud-dependencies | Finchley.SR1 | 2023.0.x | ❌ EOL | Upgrade |
| spring-cloud-dependencies | Finchley.SR2 | 2023.0.x | ❌ EOL | Upgrade |
| spring-cloud-dependencies | Greenwich.RELEASE | 2023.0.x | ❌ EOL | Upgrade |
| spring-cloud-dependencies | 2020.0.2 | 2023.0.x | ❌ EOL | Upgrade |
| spring-cloud-alibaba-dependencies | 0.9.0.RELEASE | 2023.0.x | ❌ EOL | Upgrade |
| spring-cloud-alibaba-dependencies | 2020.0.RC1 | 2023.0.x | ⚠️ RC/Outdated | Upgrade |
| spring-cloud-alibaba-dependencies | 2021.1 | 2023.0.x | ⚠️ Outdated | Upgrade |

### Core Spring Dependencies

| Package/Artifact | Current Version | Latest Stable | Status | Action |
|-----------------|-----------------|--------------|--------|--------|
| spring-boot-starter-web | 1.5.2 / 2.0.3 / 2.4.4 (managed) | 3.3.x | ❌ EOL | Upgrade via Boot BOM |
| spring-boot-starter-actuator | 2.0.3 / 2.1.0 (managed) | 3.3.x | ❌ EOL | Upgrade via Boot BOM |
| spring-boot-starter-webflux | 2.0.3 / 2.4.4 (managed) | 3.3.x | ❌ EOL | Upgrade via Boot BOM |
| spring-boot-starter-test | All versions (managed) | 3.3.x | ❌ EOL | Upgrade via Boot BOM |

### Spring Cloud Netflix (EOL)

| Package/Artifact | Current Version | Latest Stable | Status | Action |
|-----------------|-----------------|--------------|--------|--------|
| spring-cloud-starter-eureka | Dalston (managed) | N/A (removed) | ❌ EOL | Rename to `-netflix-eureka-client` |
| spring-cloud-starter-eureka-server | Dalston (managed) | N/A (renamed) | ❌ EOL | Rename to `-netflix-eureka-server` |
| spring-cloud-starter-netflix-eureka-client | Finchley/Greenwich/2020 | 4.1.x | ⚠️ Outdated | Upgrade via Cloud BOM |
| spring-cloud-starter-netflix-eureka-server | Finchley/Greenwich/2020 | 4.1.x | ⚠️ Outdated | Upgrade via Cloud BOM |
| spring-cloud-starter-ribbon | Dalston/Finchley (managed) | Removed | ❌ EOL/Removed | Replace with LoadBalancer |
| spring-cloud-starter-netflix-ribbon | Finchley (managed) | Removed | ❌ EOL/Removed | Replace with LoadBalancer |
| spring-cloud-starter-hystrix | Dalston/Finchley (managed) | Removed | ❌ EOL/Removed | Replace with Resilience4j |
| spring-cloud-starter-netflix-hystrix | Finchley (managed) | Removed | ❌ EOL/Removed | Replace with Resilience4j |
| spring-cloud-starter-hystrix-dashboard | Dalston/Finchley (managed) | Removed | ❌ EOL/Removed | Replace with Grafana |
| spring-cloud-starter-netflix-hystrix-dashboard | Finchley (managed) | Removed | ❌ EOL/Removed | Replace with Grafana |
| spring-cloud-starter-zuul | Dalston/Finchley (managed) | Removed | ❌ EOL/Removed | Replace with Gateway |
| spring-cloud-starter-netflix-zuul | Finchley (managed) | Removed | ❌ EOL/Removed | Replace with Gateway |
| spring-cloud-starter-netflix-turbine | Finchley (managed) | Removed | ❌ EOL/Removed | Replace with Micrometer |

### Spring Cloud Feign

| Package/Artifact | Current Version | Latest Stable | Status | Action |
|-----------------|-----------------|--------------|--------|--------|
| spring-cloud-starter-feign | Dalston (managed) | Removed | ❌ EOL | Replace with `openfeign` |
| spring-cloud-starter-openfeign | Finchley/2020 (managed) | 4.1.x | ⚠️ Outdated | Upgrade via Cloud BOM |

### Spring Cloud Config

| Package/Artifact | Current Version | Latest Stable | Status | Action |
|-----------------|-----------------|--------------|--------|--------|
| spring-cloud-starter-config | Dalston/Finchley (managed) | 4.1.x | ❌ EOL | Upgrade via Cloud BOM |
| spring-cloud-config-server | Dalston/Finchley (managed) | 4.1.x | ❌ EOL | Upgrade via Cloud BOM |

### Spring Cloud Gateway

| Package/Artifact | Current Version | Latest Stable | Status | Action |
|-----------------|-----------------|--------------|--------|--------|
| spring-cloud-starter-gateway | Finchley.SR1/2020.0.2 (managed) | 4.1.x | ⚠️ Outdated | Upgrade via Cloud BOM |

### Spring Cloud LoadBalancer

| Package/Artifact | Current Version | Latest Stable | Status | Action |
|-----------------|-----------------|--------------|--------|--------|
| spring-cloud-starter-loadbalancer | 2020.0.2 (managed) | 4.1.x | ⚠️ Outdated | Upgrade via Cloud BOM |

### Spring Cloud Tracing

| Package/Artifact | Current Version | Latest Stable | Status | Action |
|-----------------|-----------------|--------------|--------|--------|
| spring-cloud-starter-sleuth | Dalston/Finchley (managed) | Removed in 2022+ | ❌ EOL/Removed | Migrate to Micrometer Tracing |
| spring-cloud-starter-zipkin | Dalston (managed + `RELEASE` keyword) | Removed | ❌ EOL/Removed | Use micrometer-tracing-bridge-brave |
| spring-cloud-sleuth-zipkin-stream | Dalston (managed) | Removed | ❌ EOL/Removed | Replace with OTLP or Brave reporter |
| spring-cloud-sleuth-zipkin | Dalston (managed) | Removed | ❌ EOL/Removed | Migrate to Micrometer Tracing |
| zipkin-server | Dalston (managed) | Standalone 3.x | ❌ EOL | Use standalone Zipkin 3.x |
| zipkin-autoconfigure-ui | Dalston (managed) | Removed from Boot | ❌ EOL | Use standalone Zipkin server |

### Spring Cloud Bus & Messaging

| Package/Artifact | Current Version | Latest Stable | Status | Action |
|-----------------|-----------------|--------------|--------|--------|
| spring-cloud-starter-bus-amqp | Dalston/Finchley (managed) | 4.1.x | ❌ EOL | Upgrade via Cloud BOM |
| spring-cloud-starter-stream-rabbit | Dalston (managed) | 4.1.x | ❌ EOL | Upgrade via Cloud BOM |

### Spring Cloud Alibaba

| Package/Artifact | Current Version | Latest Stable | Status | Action |
|-----------------|-----------------|--------------|--------|--------|
| spring-cloud-starter-alibaba-nacos-discovery | 0.9.0.RELEASE / Greenwich | 2023.0.x | ❌ EOL | Upgrade to 2023.0.x |
| spring-cloud-starter-alibaba-nacos-config | Greenwich (managed) | 2023.0.x | ⚠️ Outdated | Upgrade to 2023.0.x |
| spring-cloud-starter-alibaba-sentinel | Greenwich/2020 (managed) | 2023.0.x | ⚠️ Outdated | Upgrade to 2023.0.x |

### Spring Cloud Consul

| Package/Artifact | Current Version | Latest Stable | Status | Action |
|-----------------|-----------------|--------------|--------|--------|
| spring-cloud-starter-consul-discovery | Dalston.RELEASE (managed) | 4.1.x | ❌ EOL | Upgrade via Cloud BOM |

### Monitoring

| Package/Artifact | Current Version | Latest Stable | Status | Action |
|-----------------|-----------------|--------------|--------|--------|
| de.codecentric:spring-boot-admin-starter-server | ~2.1.0 | 3.4.x | ❌ EOL | Upgrade to 3.4.x (requires Spring Boot 3.x) |
| de.codecentric:spring-boot-admin-starter-client | ~2.1.0 | 3.4.x | ❌ EOL | Upgrade to 3.4.x |

### Build Plugins

| Package/Artifact | Current Version | Latest Stable | Status | Action |
|-----------------|-----------------|--------------|--------|--------|
| spring-boot-maven-plugin | 1.5.2 / 2.0.3 / 2.4.4 (managed) | 3.3.x | ❌ EOL | Upgrade via Boot BOM |
| maven-compiler-plugin | 3.x (managed) | 3.13.x | ⚠️ Outdated | Upgrade via Maven Super POM |
| com.spotify:docker-maven-plugin | Legacy | Replaced by `jib-maven-plugin` | ❌ EOL | Replace with Jib or Buildpacks |

---

*End of Analysis*
