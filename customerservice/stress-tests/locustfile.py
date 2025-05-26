from locust import HttpUser, task, constant

class OrderServiceUser(HttpUser):
    wait_time = constant(0)

    @task
    def get_orders(self):
        self.client.get("/api/customers")
