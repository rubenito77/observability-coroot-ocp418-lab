#!/usr/bin/env bash
set -euo pipefail

NAMESPACE="boutique"

for sa in $(oc get sa -n "${NAMESPACE}" -o jsonpath='{.items[*].metadata.name}'); do
  echo "Granting anyuid SCC to serviceaccount: ${sa}"
  oc adm policy add-scc-to-user anyuid -z "${sa}" -n "${NAMESPACE}"
done
