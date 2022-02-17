1. Two Sum : 서로 다른 index의 요소 끼리 더해서 target이 되는 2개의 인덱스를 구하는 문제 (처음 발견시 리턴)
13. RomantoloInteger : 임의의 로마숫자 정수로 치환하는 문제 
20. Valid Parentheses : 괄호가 제대로 닫혔는지 구별하는 문제 ->stack을 이용한 문제 <자료구조>
21. Merge Two Sorted Lists : 오름차순으로 정렬된 2개의 linked list를 하나의 정렬된 linked list로 만드는 문제 ->linked list 관련 문제 <자료구조>
53. Maximum Subarray : subarry의 sum이 가장 큰 값을 찾는 문제 
88. Merge Sorted Array : 2개의 오름차순으로 정렬된 리스트를 첫번째 list에 합쳐서 정렬하는 문제 -> Merge sort 관련문제 <알고리즘>
141. Linked List Cycle : linked lsit가 cycle이 있는지 확인하는 문제 -> linked lsit 관련 <자료구죠>
155. Min Stack : stack의 init, push, pop, top, getMin을 만드는 문제 -> stack 문제<자료구조>
160. Intersection of Two Linked Lists : linked listd의 교집합을 찾는 문제 있으면 교집합의 주소를 없으면 None 반환 -> linked list 문제 <자료구조>
169. Majority Element : list의 원소중 list의 길이의 절반보다 긴 수를 가진 원소를 반환하는 문제 -> set을 이용하여 풀이 <set과 list는 유사한 함수를 사용한다.>
172. Factorial Trailing Zeroes : n!의 tail의 0의 수를 구하는 문제 -> 5*2=10이다 따라서 n!를 소인수 분해햇을때 5의 수를 구하면 0의 수를 알 수 있다.
189. Rotate Array : Array를 주어진 k 만큼 회전시키는 문제 -> list의 얕은 복사/ 깉은 복사가 키포인트  
198. House Robber : 연속된 집을 털경우 경보가 발생 / 주어진 배열에서 최대로 털수 있는 금액을 구하는 문제 -> dynamic program <알고리즘> <*>
202. Happy Number : 각 자리의 수를 제곱하여 더하여 수를 생성(반복) + 이수가 1이면 true 만약 loop에 빠지면 false를 반환하는 문제
204. Count Primes : n보다 작은 primes의 수를 세는 문제 -> 알고리즘, 자료구조 문제는 아니지만 time complexity를 고민해야하는 문제 
205. Isomorphic Strings : 2개의 string이 존재할때 2개의 string의 구조가 동일한가를 판단하는 문제 (s1의 알파벳은 s2의 알파벳중 하나로 mapping<동일 알파벳이 다른 알파벳으로 mapping불가>)
226. Invert Binary Tree : Binary Tree의 왼쪽 오른쪽 자식들을 바꾸는 문제 -> Binary Tree <자료구조>
242. Valid Anagram : 두 string을 구성하는 알파벳이 동일한지 파악하는 알고리즘 ->string관련 문제
371. Sum of Two Integers : 두수를 더하는데 +,-기호를 안쓰고 더하기
448. Find All Numbers Disappeared in an Array : array속에 없는 숫자를 찾는 문제 -> set이용시 편하다
557. Reverse Words in a String III : 주어진 문자열를 단어별로 reverse한 문자열을 생성하는 문제 -> slice, reversed함수
572. Subtree of Another Tree : 
605. Can Place Flowers : 주어진 배열에서 1은 연속적으로 존재하지 못할때 1을 넣을수 있는 최대 수 