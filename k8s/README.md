# How to run the application with Kubernetes

## Create the PersistentVolume (PV) and PersistentVolumeClaim (PVC)
1. Apply the PV and PVC for Postgres
```bash
kubectl apply -f postgresql-pv.yaml
kubectl apply -f postgresql-pvc.yaml
```
2. Check if the PV and PVC are created
```bash
kubectl get pv
kubectl get pvc
```

## Create the Postgres Deployment and Service
1. Apply the Postgres Deployment
```bash
kubectl apply -f postgresql-deployment.yaml
kubectl apply -f postgresql-service.yaml
```

2. Check if the Postgres Deployment and Service are created
```bash
kubectl get deployments
kubectl get services
```

## Create the Application Deployment and Service
1. Apply the Application Deployment
```bash
kubectl apply -f app-deployment.yaml
kubectl apply -f app-service.yaml
```

2. Check if the Application Deployment and Service are created
```bash
kubectl get deployments
kubectl get services
```

## Check the Application logs
1. See the logs of the application
```bash
kubectl get pods
```

```bash
kubectl logs -f <pod-name>
```

2. Access the application bash
```bash
kubectl get pods
```

```bash
kubectl exec -it <pod-name> -- /bin/bash
```

## Access the application
1. Local
   http://localhost:30007/swagger-ui/index.html#
2. In the cloud
   http://<node-ip>:30007/swagger-ui/index.html#

## Delete the resources
1. Delete a resource
```bash
kubectl delete -f <resource-file>
```

```bash
kubectl delete <tipo> <nome-do-pod>
```

2. Delete all resources
```bash
kubectl delete deployments --all -n default
kubectl delete replicasets --all -n default
kubectl delete statefulsets --all -n default
kubectl delete services --all -n default
kubectl delete pods --all -n default
kubectl delete pvc --all -n default
kubectl delete hpa --all -n default
```