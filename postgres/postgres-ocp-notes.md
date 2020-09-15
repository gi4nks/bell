oc rsh <podname>

psql -h postgres $POSTGRES_DB $POSTGRES_USER $POSTGRES_PASSWORD -c "SELECT * FROM (SELECT current_database()) cdb CROSS JOIN (SELECT current_user) cu"





oc expose deployment.apps/postgres --port=5432 --target-port=5432 --type=LoadBalancer --name postgres-lb





kind: PersistentVolume
apiVersion: v1
metadata:
  name: postgres-pv-volume
  labels:
    type: local
    app: postgres
spec:
  storageClassName: ocs-storagecluster-cephfs
  capacity:
    storage: 5Gi
  accessModes:
    - ReadWriteMany
  volumeMode: Filesystem
---