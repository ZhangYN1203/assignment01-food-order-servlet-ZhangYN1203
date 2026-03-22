#!/bin/bash

score=0
failed=0

run_test () {
  bash "$1"
  if [ $? -eq 0 ]; then
    score=$((score+10))
  else
    failed=$((failed+1))
  fi
}

run_test src/test/test1_menu.sh
run_test src/test/test2_search.sh
run_test src/test/test3_empty_search.sh
run_test src/test/test4_create_order.sh
run_test src/test/test5_missing_param.sh
run_test src/test/test6_invalid_quantity.sh
run_test src/test/test7_order_detail.sh
run_test src/test/test8_order_not_found.sh
run_test src/test/test9_create_then_query.sh
run_test src/test/test10_html_exist.sh

echo "================================="
echo "TOTAL SCORE: $score / 100"
echo "================================="

if [ $failed -ne 0 ]; then
  exit 1
fi

