class ArrayQueue:
    def __init__(self):
        self.data = []
        self.front = 0

    def __len__(self):
        return len(self.data) - self.front

    def is_empty(self):
        return len(self) == 0

    def enqueue(self, e):
        self.data.append(e)

    def dequeue(self):
        if self.is_empty():
            raise Exception('Queue is empty')
        answer = self.data[self.front]
        self.data[self.front] = None  # help garbage collection
        self.front += 1
        return answer

    def first(self):
        if self.is_empty():
            raise Exception('Queue is empty')
        return self.data[self.front]

    def rotate(self):
        if len(self) > 1:
            self.data.append(self.data.pop(self.front))
