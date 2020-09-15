https://severalnines.com/database-blog/using-kubernetes-deploy-postgresqloc

## Create in right sequence
oc create -f postgres-configmap.yaml 
oc create -f postgres-storage.yaml
oc create -f postgres-deployment.yaml  
oc create -f postgres-service.yaml
oc port-forward service/postgres 5432

## Create in right sequence
oc create -f postgres-configmap.yaml 
oc create -f postgres-storage.yaml
oc create -f postgres-statefulset.yaml
oc create -f postgres-service.yaml
oc port-forward service/postgres 5432


oc create -f postgres-configmap.yaml 
oc create -f postgres-statefulset-with-anom-volumeclaim.yaml
oc create -f postgres-service.yaml
oc port-forward service/postgres 5432

## Delete in right sequence
oc delete service postgres 
oc delete deployment postgres
oc delete statefulset postgres
oc delete configmap postgres-config
oc delete persistentvolumeclaim postgres-pv-claim
oc delete persistentvolume postgres-pv-volume

## Create in right sequence
kubectl create -f postgres-configmap.yaml 
kubectl create -f postgres-deployment.yaml 
kubectl create -f postgres-service.yaml
kubectl create -f postgres-storage.yaml


#Not required not
kubectl create -f postgres-storage.yaml
kubectl create -f postgres-service-clusterip.yaml

## Delete in right sequence
kubectl delete service postgres 
kubectl delete deployment postgres
kubectl delete configmap postgres-config
kubectl delete persistentvolumeclaim postgres-pv-claim
kubectl delete persistentvolume postgres-pv-volume

