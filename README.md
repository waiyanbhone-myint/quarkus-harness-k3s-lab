This project follows a modern DevOps lifecycle, divided into three distinct phases:

1. The Build Phase (Continuous Integration)
Developer Action: Code changes are committed and pushed to the GitHub repository.

Trigger: A GitHub Actions workflow is automatically triggered upon every push to the main branch.

Artifact Creation: The workflow compiles the Java source code using Maven and builds a container image using the Quarkus optimized Dockerfile.

Storage: The finalized image is tagged and pushed to Docker Hub, serving as the central container registry.

2. The Deployment Phase (Continuous Delivery)
Orchestration: Harness CD detects the new image version in Docker Hub and initiates the deployment pipeline.

Communication: The Harness Delegate (running within the cluster) receives the deployment instructions and updates the Kubernetes manifests.

K3s Update: The K3s cluster pulls the latest image from Docker Hub and performs a rolling update, ensuring the new version of the microservice is deployed with zero downtime.

3. The Runtime Phase (Infrastructure & Connection)
Configuration: The Pod starts up and injects sensitive environment variables (Database credentials and Host IP) via Kubernetes Secrets.

Data Connectivity: The Quarkus application establishes a secure JDBC connection to the PostgreSQL database using the internal network routing provided by the Ubuntu VM host.

Service Delivery: A Kubernetes Service exposes the application, allowing traffic to reach the functional API.

<img width="593" height="197" alt="Screenshot 2026-02-22 at 3 00 16 PM" src="https://github.com/user-attachments/assets/0df31084-9eab-4146-96a3-858b79bfecaf" />
<img width="10<img width="828" height="376" alt="Screenshot 2026-02-22 at 2 59 02 PM" src="https://github.com/user-attachments/assets/49ab5503-7f29-43af-bae5-d9c003f69795" />
<img width="755" height="594" alt="Screenshot 2026-02-22 at 2 58 39 PM" src="https://github.com/user-attachments/assets/cbcb46b6-d0c4-4512-815b-4760d52f3e1c" />
<img width="823" height="381" alt="Screenshot 2026-02-22 at 2 58 55 PM" src="https://github.com/user-attachments/assets/f8ae7dde-151b-4b87-ab55-d77caf21addb" />
