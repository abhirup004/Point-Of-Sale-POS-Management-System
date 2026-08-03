# POS Frontend

A React frontend for a Point of Sale management system. It provides browser-based interfaces for managing companies, units, products, and purchase-related workflows against the POS Spring Boot API.

## Features

- Dashboard and responsive application layout
- Company management with create, search, sort, edit, status update, and delete actions
- Unit and product management
- Purchase workflow screens
- Client-side form validation and paginated API data handling
- Reusable navigation components and route-based pages

## Technology Stack

- React 19
- React Router
- Axios
- Vite
- Tailwind CSS
- JavaScript

## Project Structure

```text
src/
  components/     Feature pages and reusable UI components
  utilities/      Shared constants
  Header.jsx      Application header
  Sidebar.jsx     Application navigation
  main.jsx        Route configuration and application entry point
```

## Getting Started

### Prerequisites

- Node.js 20 or later
- npm
- The POS backend running locally

### Run locally

```bash
npm install
npm run dev
```

Vite starts the frontend at `http://localhost:5173` by default. The current API base URL is `http://localhost:8080/api`, so start the backend before using data-management screens.

## Available Scripts

| Command | Purpose |
| --- | --- |
| `npm run dev` | Starts the local Vite development server |
| `npm run build` | Creates a production build |
| `npm run preview` | Serves the production build locally |
| `npm run lint` | Runs ESLint |

## Backend Integration

The frontend calls the POS REST API for company, unit, product, and purchase data. Protected backend routes require a JWT bearer token, so authentication should be completed before making protected API calls.
