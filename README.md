### 🔄 Project Workflow: Local Code to K3s Deployment

This project follows a modern DevOps lifecycle, divided into three distinct phases:

#### 1. The Build Phase (Continuous Integration)

* **Developer Action:** Code changes are committed and pushed to the **GitHub** repository.
* **Trigger:** A **GitHub Actions** workflow is automatically triggered upon every push to the `main` branch.
* **Artifact Creation:** The workflow compiles the Java source code using Maven and builds a container image using the **Quarkus** optimized Dockerfile.
* **Storage:** The finalized image is tagged and pushed to **Docker Hub**, serving as the central container registry.

#### 2. The Deployment Phase (Continuous Delivery)

* **Orchestration:** **Harness CD** detects the new image version in Docker Hub and initiates the deployment pipeline.
* **Communication:** The Harness Delegate (running within the cluster) receives the deployment instructions and updates the Kubernetes manifests.
* **K3s Update:** The **K3s cluster** pulls the latest image from Docker Hub and performs a rolling update, ensuring the new version of the microservice is deployed with zero downtime.

#### 3. The Runtime Phase (Infrastructure & Connecti<img width="593" height="197" alt="Screenshot 2026-02-22 at 3 00 16 PM" src="https://github.com/user-attachments/assets/dced8a16-1ab4-4c6d-9cd4-30be6a204e8c" />
on)

* **Configuration:** The Pod starts up and injects sensitive environment variables (Database credentials and Host IP) via **Kubernetes Secrets**.
* **Data Connectivity:** The Quarkus application establishes a secure JDBC connection to the **PostgreSQL database** using the internal network routing provided by the Ubuntu VM host.
* **Service Delivery:** A Kubernete<img width="1004" height="320" alt="Screenshot 2026-02-22 at 2 59 19 PM" src="https://github.com/user-attachments/assets/93eb5729-9b27-4f6e-ae08-842cf6d1d4ae" />
s Service exposes the application, allowing traffic to reach the functional API.

---
"This automated flow ensures that the tr<img width="828" height="376" alt="Screenshot 2026-02-22 at 2 59 02 PM" src="https://github.com/user-attachments/assets/7241d30b-3277-4c54-86ea-e26fb958fac4" />
ansition from development to production is consistent, repeatable, and secure. By leveraging **Harness CD** for orchestration and **K3s** for lightweight container management, the project demonstrates a production-ready CI/CD pattern in a resource-efficient Home Lab environment."<img width="755" height="594" alt="Screenshot 2026-02-22 at 2 58 39 PM" src="https://github.com/user-attachments/assets/176b65f3-174f-40d7-aa72-fb0eac601a1e" />
