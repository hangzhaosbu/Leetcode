# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        
        if len(lists) == 0:
            return None
        
        def merge2(list1, list2):
            if not list1 or not list2:
                return list1 or list2
            
            if list1.val < list2.val:
                list1.next = merge2(list1.next, list2)
                return list1
            else:
                list2.next = merge2(list1, list2.next)
                return list2
        
        
        while len(lists) > 1:
            curt = []
            
            for i in range(0, len(lists), 2):
                if i != len(lists) - 1:
                    curt.append(merge2(lists[i], lists[i + 1]))
                else:
                    curt.append(lists[i])
            
            lists = curt
        
        return lists[0]