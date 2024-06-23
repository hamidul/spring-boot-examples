# Example Execution Flow
## First Request:

- URL: http://localhost:8080/get/someParam
- No cache entry for "someParam".
- simulateSlowService is called (3 seconds delay).
- Result "Data for someParam" is cached.
## Subsequent Requests:

URL: http://localhost:8080/get/someParam
- Cache entry for "someParam" is found.
- Cached result "Data for someParam" is returned immediately.
- simulateSlowService is not called.

This is why you observe that subsequent requests are much faster and do not trigger the simulateSlowService method—the result is served directly from the cache.