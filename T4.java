






def josephus(n, k):
    q = ArrayQueue()
    for i in range(1, n+1):
        q.enqueue(i)
    while len(q) > 1:
        for i in range(k-1):
            q.enqueue(q.dequeue())
        q.dequeue()
    return q.dequeue()






def round_robin(processes, quantum):
    q = ArrayQueue()
    waiting_time = 0
    for process in processes:
        q.enqueue(process)
    while not q.is_empty():
        current_process = q.dequeue()
        if current_process <= quantum:
            waiting_time += current_process
        else:
            waiting_time += quantum
            q.enqueue(current_process - quantum)
        if current_process > quantum:
            q.enqueue(current_process - quantum)
    return waiting_time
