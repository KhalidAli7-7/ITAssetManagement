
    public class Ticket {
        private String ticketId;
        private String assetId;
        private String description;
        private String status; // "OPEN", "IN_PROGRESS", "RESOLVED"

        public Ticket(String ticketId, String assetId, String description) {
            this.ticketId = ticketId;
            this.assetId = assetId;
            this.description = description;
            this.status = "OPEN"; // New tickets start as OPEN
        }

        // --- Getters ---
        public String getTicketId() {
            return ticketId;
        }

        public String getAssetId() {
            return assetId;
        }

        public String getDescription() {
            return description;
        }

        public String getStatus() {
            return status;
        }

        // --- Status updates ---
        public void setStatus(String status) {
            this.status = status;
        }

        public String getSummary() {
            return "[Ticket #" + ticketId + "] Asset: " + assetId + " | Issue: " + description + " | Status: " + status;
        }
    }

