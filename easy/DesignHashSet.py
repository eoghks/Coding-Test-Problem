class MyHashSet(object):
    
    def __init__(self):
        self.myset=[]

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        if self.contains(key):
            return
        self.myset.append(key)

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        if(self.contains(key)):
            self.myset.remove(key)
        return

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        if key in self.myset:
            return True
        return False
